package haydende.mongodbdemo.repositories;

import haydende.mongodbdemo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher, String> {

    Optional<Teacher> findByLastName(String lastName);
}
