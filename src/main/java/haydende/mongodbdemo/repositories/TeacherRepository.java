package haydende.mongodbdemo.repositories;

import haydende.mongodbdemo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
