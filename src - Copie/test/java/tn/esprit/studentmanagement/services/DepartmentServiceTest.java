package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void testGetAllDepartments() {
        List<Department> deps = Arrays.asList(new Department(), new Department());
        when(departmentRepository.findAll()).thenReturn(deps);

        List<Department> result = departmentService.getAllDepartments();

        assertEquals(2, result.size());
        verify(departmentRepository).findAll();
    }

    @Test
    void testGetDepartmentById() {
        Department d = new Department();
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(d));

        Department result = departmentService.getDepartmentById(1L);

        assertNotNull(result);
        assertSame(d, result);
    }

    @Test
    void testSaveDepartment() {
        Department d = new Department();
        when(departmentRepository.save(d)).thenReturn(d);

        Department saved = departmentService.saveDepartment(d);

        assertEquals(d, saved);
        verify(departmentRepository).save(d);
    }

    @Test
    void testDeleteDepartment() {
        doNothing().when(departmentRepository).deleteById(1L);

        departmentService.deleteDepartment(1L);

        verify(departmentRepository).deleteById(1L);
    }
}
