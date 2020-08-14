package haydende.mongodbdemo.service;

import haydende.mongodbdemo.domain.Teacher;
import haydende.mongodbdemo.repositories.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

class TeacherServiceImplTest {

    public static final String ID = String.valueOf(1L);
    public static final String LAST_NAME = "LASTNAME";

    @Mock
    TeacherRepository teacherRepository;

    TeacherService teacherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    @Test
    void findById() {
        Teacher teacher = Teacher
            .builder()
            .id(ID)
            .build();

        BDDMockito.given(teacherRepository.findById(anyString())).willReturn(Optional.of(teacher));

        Teacher actualTeacher = teacherService.findById(ID);

        assertEquals(ID, actualTeacher.getId());
    }

    @Test
    void findByLastName() {
        Teacher teacher = Teacher
            .builder()
            .lastName(LAST_NAME)
            .build();

        BDDMockito.given(teacherRepository.findByLastName(anyString())).willReturn(Optional.of(teacher));

        Teacher actualTeacher = teacherService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, actualTeacher.getLastName());
    }

    @Test
    void save() {
        Teacher teacherToSave = Teacher
            .builder()
            .id(ID)
            .build();

        Teacher savedTeacher = Teacher
            .builder()
            .id(ID)
            .build();

        BDDMockito.given(teacherRepository.save(any(Teacher.class))).willReturn(savedTeacher);

        Teacher actualSavedTeacher = teacherService.save(teacherToSave);

        assertEquals(teacherToSave, actualSavedTeacher);
    }

    @Test
    void delete() {
        Teacher teacher = Teacher
            .builder()
            .build();

        teacherService.delete(teacher);

        BDDMockito.verify(teacherRepository, Mockito.times(1)).delete(teacher);
    }

    @Test
    void deleteById() {
        teacherService.deleteById(ID);
        BDDMockito.verify(teacherRepository, Mockito.times(1)).deleteById(ID);
    }

    @Test
    void deleteAll() {
        teacherService.deleteAll();
        BDDMockito.verify(teacherRepository, Mockito.times(1)).deleteAll();
    }
}