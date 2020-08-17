package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Subject;
import haydende.mongodbdemo.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject findByName(String name) {
        Optional<Subject> subject = subjectRepository.findById(name);
        if (subject.isPresent()) {
            return subject.get();
        }
        throw new RuntimeException("No Subject with an name of " + name + " has been found!");
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Subject... subjects) {
        for (Subject s: subjects) {
            subjectRepository.delete(s);
        }
    }

    @Override
    public void deleteById(String id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }
}
