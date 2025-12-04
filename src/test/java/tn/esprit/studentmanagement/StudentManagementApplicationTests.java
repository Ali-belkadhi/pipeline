package tn.esprit.studentmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.studentmanagement.controllers.StudentController;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.services.IStudentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    private StudentController controller;

    @BeforeEach
    void setUp() {
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(
                new Student(1L, "John", "Doe"),
                new Student(2L, "Jane", "Smith")
        ));
        controller = new StudentController(studentService);
    }

    @Test
    void testGetAllStudents() {
        List<Student> result = controller.getAllStudents();
        assertEquals(2, result.size());
    }
}
