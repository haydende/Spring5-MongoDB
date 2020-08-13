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
            .firstName("Stew")
            .lastName("Dent")
            .build();

        Teacher teacher = Teacher
            .builder()
            .firstName("Tee")
            .lastName("Cher")
            .build();

        Subject subject = Subject
            .builder()
            .description("Chemistry")
            .teacher(teacher)
            .build();

        subject.addStudent(student);
        student.addSubject(subject);
        subject.setTeacher(teacher);
        teacher.setSubject(subject);

        studentRepository.save(student);
        subjectRepository.save(subject);
        teacherRepository.save(teacher);
    }
}
