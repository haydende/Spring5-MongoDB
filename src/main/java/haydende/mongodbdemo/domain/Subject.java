package haydende.mongodbdemo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document
public class Subject {

    /**
     * String id of this subject.
     */
    @Id
    private String subject;

    /**
     * String name of this subject.
     */
    private String description;

    /**
     * String id of the students taking this subject.
     */
    private Set<String> students;

    /**
     * String id of the teacher teaching this subject.
     */
    private String teacher;
}
