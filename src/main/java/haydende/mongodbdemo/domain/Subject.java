package haydende.mongodbdemo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document
public class Subject {

    /**
     * String name of this subject.
     */
    @Id
    private String subject;

    /**
     * Set of Students doing this subject
     */
    @ToString.Exclude
    @Builder.Default
    @DBRef
    private Set<Student> students = new HashSet<>();

    /**
     * ID of the Teacher teaching this subject.
     */
    @EqualsAndHashCode.Exclude
    private String teacher;

    public void addStudent(Student student) {
        students.add(student);
    }

}
