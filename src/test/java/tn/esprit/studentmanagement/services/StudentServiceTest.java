package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetAllStudents() {
        List<Student> students = Arrays.asList(new Student(1L, "John", "Doe"), new Student(2L, "Jane", "Smith"));
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
        verify(studentRepository).findAll();
    }

    @Test
    void testGetStudentByIdFound() {
        Student s = new Student(1L, "John", "Doe");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(s));

        Student result = studentService.getStudentById(1L);

        assertNotNull(result);
        assertSame(s, result);
    }

    @Test
    void testGetStudentByIdNotFound() {
        when(studentRepository.findById(5L)).thenReturn(Optional.empty());

        Student result = studentService.getStudentById(5L);

        assertNull(result);
    }

    @Test
    void testSaveStudent() {
        Student s = new Student(1L, "John", "Doe");
        when(studentRepository.save(s)).thenReturn(s);

        Student saved = studentService.saveStudent(s);

        assertEquals(s, saved);
        verify(studentRepository).save(s);
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        verify(studentRepository).deleteById(1L);
    }
}
