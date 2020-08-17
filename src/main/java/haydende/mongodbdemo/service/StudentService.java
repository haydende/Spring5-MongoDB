package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Student;

import java.util.List;

public interface StudentService {

    Student findById(String id);

    Student findByLastName(String lastName);

    List<Student> findAll();

    Student save(Student student);

    void delete(Student... students);

    void deleteById(String id);

    void deleteAll();
}
