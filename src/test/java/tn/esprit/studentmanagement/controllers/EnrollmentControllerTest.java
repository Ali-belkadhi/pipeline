package tn.esprit.studentmanagement.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.services.IEnrollment;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnrollmentControllerTest {

    @Mock
    private IEnrollment enrollmentService;

    private EnrollmentController controller;

    @BeforeEach
    void setUp() {
        controller = new EnrollmentController(enrollmentService);
    }

    @Test
    void testGetAllEnrollment() {
        var list = Arrays.asList(new Enrollment(), new Enrollment());
        when(enrollmentService.getAllEnrollments()).thenReturn(list);
        var result = controller.getAllEnrollment();
        assertEquals(2, result.size());
    }
}
