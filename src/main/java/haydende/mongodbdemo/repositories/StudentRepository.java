package haydende.mongodbdemo.repositories;

import haydende.mongodbdemo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
