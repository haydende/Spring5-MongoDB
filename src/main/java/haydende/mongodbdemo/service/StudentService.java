package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Student;

public interface StudentService {

    Student findById(String id);

    Student findByLastName(String lastName);

    Student save(Student student);

    void delete(Student... students);

    void deleteById(String id);

    void deleteAll();
}
