package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Subject;

import java.util.List;

public interface SubjectService {

    Subject findByName(String name);

    List<Subject> findAll();

    Subject save(Subject subject);

    void delete(Subject... subjects);

    void deleteById(String id);

    void deleteAll();
}
