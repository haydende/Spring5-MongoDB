package haydende.mongodbdemo.repositories;

import haydende.mongodbdemo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findByLastName(String name);
}
