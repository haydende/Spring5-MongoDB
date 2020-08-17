package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Student;
import haydende.mongodbdemo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(String id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        throw new RuntimeException("No student with that ID has been found");
    }

    @Override
    public Student findByLastName(String lastName) {
        Optional<Student> student = studentRepository.findByLastName(lastName);
        if(student.isPresent()) {
            return student.get();
        }
        throw new RuntimeException("No student with that Last Name has been found");
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
//         return studentRepository.save(student);
    }

    @Override
    public void delete(Student... students) {
        for (Student s : students) {
            studentRepository.delete(s);
        }
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
