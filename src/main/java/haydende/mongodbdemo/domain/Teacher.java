package haydende.mongodbdemo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Teacher {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    /**
     * Name of the Subject this teacher teaches for.
     */
    @DBRef
    private Subject subject;
}
