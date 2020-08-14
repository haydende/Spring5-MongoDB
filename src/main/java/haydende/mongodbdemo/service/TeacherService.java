package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Teacher;

public interface TeacherService {

    Teacher findById(String id);

    Teacher findByLastName(String lastName);

    Teacher save(Teacher teacher);

    void delete(Teacher... teachers);

    void deleteById(String id);

    void deleteAll();
}
