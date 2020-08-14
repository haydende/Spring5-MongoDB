package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Student;
import haydende.mongodbdemo.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

class StudentServiceTest {

    public static final String ID = String.valueOf(1L);
    public static final String FIRST_NAME = "Stew";
    public static final String LAST_NAME = "Dent";

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findById() {
        Student student = Student
            .builder()
            .id(ID)
            .build();

        BDDMockito.given(studentRepository.findById(anyString())).willReturn(Optional.of(student));

        Student actualStudent = studentService.findById(ID);

        assertEquals(ID, actualStudent.getId());
    }

    @Test
    void findByLastName() {
        Student student = Student
            .builder()
            .lastName(LAST_NAME)
            .build();

        BDDMockito.given(studentRepository.findByLastName(anyString())).willReturn(Optional.of(student));

        Student actualStudent = studentService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, actualStudent.getLastName());
    }

    @Test
    void save() {
        Student student = Student
            .builder()
            .id(ID)
            .build();

        Student savedStudent = Student
            .builder()
            .id(ID)
            .build();

        BDDMockito.given(studentRepository.save(any(Student.class))).willReturn(savedStudent);

        Student actualStudent = studentService.save(student);

        BDDMockito.verify(studentRepository, times(1)).save(any(Student.class));

        assertEquals(student, actualStudent);
    }

    @Test
    void delete() {
        Student student = Student
            .builder()
            .build();

        studentService.delete(student);

        BDDMockito.verify(studentRepository, times(1)).delete(any(Student.class));
    }

    @Test
    void deleteById() {
        studentService.deleteById(ID);
        BDDMockito.verify(studentRepository, times(1)).deleteById(anyString());
    }

    @Test
    void deleteAll() {
        studentService.deleteAll();
        BDDMockito.verify(studentRepository, times(1)).deleteAll();
    }
}