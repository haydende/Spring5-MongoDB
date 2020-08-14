package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Teacher;
import haydende.mongodbdemo.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher findById(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        throw new RuntimeException("No Teacher with ID of: " + id + " has been found!");
    }

    @Override
    public Teacher findByLastName(String lastName) {
        Optional<Teacher> teacher = teacherRepository.findByLastName(lastName);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        throw new RuntimeException("No Teacher with a last name of: " + lastName + " has been found!");
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher... teachers) {
        for (Teacher t: teachers) {
            teacherRepository.delete(t);
        }
    }

    @Override
    public void deleteById(String id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        teacherRepository.deleteAll();
    }
}
