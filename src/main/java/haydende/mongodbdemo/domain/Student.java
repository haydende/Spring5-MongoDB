package haydende.mongodbdemo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.security.auth.Subject;
import java.util.Set;

@Data
@Builder
@Document
public class Student {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Byte[] profileImage;
    private Set<Subject> subjects;
}
