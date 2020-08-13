package haydende.mongodbdemo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Teacher {

    private String id;

    private String firstName;
    private String lastName;

    /**
     * String id of the subject this teacher teaches for.
     */
    private String subject;
}
