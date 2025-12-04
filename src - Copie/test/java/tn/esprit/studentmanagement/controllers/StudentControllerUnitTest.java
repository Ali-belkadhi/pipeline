package tn.esprit.studentmanagement.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.services.IStudentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerUnitTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAndUpdateCallService() {
        Student s = new Student(1L, "Alice", "Wonder");
        when(studentService.saveStudent(s)).thenReturn(s);

        Student created = studentController.createStudent(s);
        assertSame(s, created);

        Student updated = studentController.updateStudent(s);
        assertSame(s, updated);

        verify(studentService, times(2)).saveStudent(s);
    }
}
