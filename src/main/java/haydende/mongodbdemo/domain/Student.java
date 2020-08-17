package haydende.mongodbdemo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
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

    @EqualsAndHashCode.Exclude
    private String firstName;

    @EqualsAndHashCode.Exclude
    private String lastName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Byte[] profileImage;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<String> subjects = new HashSet<>();

    public void addSubject(String subject) {
        subjects.add(subject);
    }
}
