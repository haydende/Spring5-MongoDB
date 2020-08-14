package haydende.mongodbdemo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
@Builder
@Document
public class Student {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Byte[] profileImage;

    @DBRef
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<Subject> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
