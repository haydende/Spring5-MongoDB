package haydende.mongodbdemo.bootstrap;

import haydende.mongodbdemo.domain.Student;
import haydende.mongodbdemo.domain.Subject;
import haydende.mongodbdemo.domain.Teacher;
import haydende.mongodbdemo.repositories.StudentRepository;
import haydende.mongodbdemo.repositories.SubjectRepository;
import haydende.mongodbdemo.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public DataLoader(StudentRepository studentRepository, SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.count() == 0 ||
            subjectRepository.count() == 0 ||
            teacherRepository.count() == 0) {
            addData();
        }
    }

    private void addData() {
        Student student = Student
            .builder()
            .id(String.valueOf(1L))
            .firstName("Stew")
            .lastName("Dent")
            .build();

        Student student2 = Student
            .builder()
            .id(String.valueOf(2L))
            .firstName("Stoo")
            .lastName("Dent")
            .build();

        Teacher teacher = Teacher
            .builder()
            .id(String.valueOf(1L))
            .firstName("Tee")
            .lastName("Cher")
            .build();

        Subject subject = Subject
            .builder()
            .subject("Chemistry")
            .teacher(teacher)
            .build();

        subject.addStudent(student);
        subject.addStudent(student2);
        student.addSubject(subject);
        student2.addSubject(subject);
        subject.setTeacher(teacher);
        teacher.setSubject(subject);

        studentRepository.save(student);
        subjectRepository.save(subject);
        teacherRepository.save(teacher);
    }
}
