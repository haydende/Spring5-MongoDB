package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Subject;
import haydende.mongodbdemo.repositories.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

class SubjectServiceTest {

    public static final String NAME = "Science";

    @Mock
    SubjectRepository subjectRepository;

    @InjectMocks
    SubjectServiceImpl subjectService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findByName() {
        Subject subject = Subject
            .builder()
            .subject(NAME)
            .build();

        BDDMockito.given(subjectRepository.findById(anyString())).willReturn(Optional.of(subject));

        Subject actualSubject = subjectService.findByName(NAME);

        assertEquals(NAME, actualSubject.getSubject());
    }

    @Test
    void findAll() {
        List<Subject> subjects =
            Arrays.asList(
                Subject.builder().build(),
                Subject.builder().build()
            );

        BDDMockito.given(subjectRepository.findAll()).willReturn(subjects);

        List<Subject> actualSubjects = subjectRepository.findAll();

        assertEquals(2, actualSubjects.size());
    }

    @Test
    void save() {
        Subject subject = Subject
            .builder()
            .subject(NAME)
            .build();

        Subject savedSubject = Subject
            .builder()
            .subject(NAME)
            .build();

        BDDMockito.given(subjectRepository.save(any(Subject.class))).willReturn(savedSubject);

        Subject actualSubject = subjectService.save(subject);

        assertEquals(subject, actualSubject);
    }

    @Test
    void delete() {
        Subject subject = Subject
            .builder()
            .build();

        subjectService.delete(subject);

        BDDMockito.verify(subjectRepository, times(1)).delete(any(Subject.class));
    }

    @Test
    void deleteById() {
        subjectService.deleteById(NAME);
        BDDMockito.verify(subjectRepository, times(1)).deleteById(anyString());
    }

    @Test
    void deleteAll() {
        subjectService.deleteAll();
        BDDMockito.verify(subjectRepository, times(1)).deleteAll();
    }
}