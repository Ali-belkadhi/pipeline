package tn.esprit.studentmanagement.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.services.IStudentService;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerMoreTest {

    @Mock
    private IStudentService studentService;

    private StudentController controller;

    @BeforeEach
    void setUp() {
        controller = new StudentController(studentService);
    }

    @Test
    void testGetStudentById() {
        Student s = new Student(1L, "John", "Doe");
        when(studentService.getStudentById(1L)).thenReturn(s);
        Student result = controller.getStudent(1L);
        assert result != null;
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentService).deleteStudent(1L);
        controller.deleteStudent(1L);
        verify(studentService).deleteStudent(1L);
    }
}
