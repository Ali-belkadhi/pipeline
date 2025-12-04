package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.repositories.EnrollmentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @Test
    void testGetAllEnrollments() {
        List<Enrollment> list = Arrays.asList(new Enrollment(), new Enrollment());
        when(enrollmentRepository.findAll()).thenReturn(list);

        List<Enrollment> result = enrollmentService.getAllEnrollments();

        assertEquals(2, result.size());
        verify(enrollmentRepository).findAll();
    }

    @Test
    void testGetEnrollmentById() {
        Enrollment e = new Enrollment();
        when(enrollmentRepository.findById(1L)).thenReturn(Optional.of(e));

        Enrollment result = enrollmentService.getEnrollmentById(1L);

        assertNotNull(result);
    }

    @Test
    void testSaveEnrollment() {
        Enrollment e = new Enrollment();
        when(enrollmentRepository.save(e)).thenReturn(e);

        Enrollment saved = enrollmentService.saveEnrollment(e);

        assertEquals(e, saved);
        verify(enrollmentRepository).save(e);
    }

    @Test
    void testDeleteEnrollment() {
        doNothing().when(enrollmentRepository).deleteById(1L);

        enrollmentService.deleteEnrollment(1L);

        verify(enrollmentRepository).deleteById(1L);
    }
}
