package haydende.mongodbdemo.repositories;

import haydende.mongodbdemo.domain.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
