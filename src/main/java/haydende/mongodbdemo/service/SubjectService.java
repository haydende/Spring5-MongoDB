package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Subject;

public interface SubjectService {

    Subject findByName(String name);

    Subject save(Subject subject);

    void delete(Subject... subjects);

    void deleteById(String id);

    void deleteAll();
}
