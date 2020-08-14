package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Subject;

public interface SubjectService {

    Subject findByName(String name);

    Subject save(Subject subject);

    Subject save(Subject... subjects);

    void delete(Subject subject);

    void delete(Subject... subjects);

    void deleteById(String id);

    void deleteAll();
}
