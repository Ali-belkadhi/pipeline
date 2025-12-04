package tn.esprit.studentmanagement.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.services.IDepartmentService;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @Mock
    private IDepartmentService departmentService;

    private DepartmentController controller;

    @BeforeEach
    void setUp() {
        controller = new DepartmentController(departmentService);
    }

    @Test
    void testGetAllDepartment() {
        var deps = Arrays.asList(new Department(), new Department());
        when(departmentService.getAllDepartments()).thenReturn(deps);
        var result = controller.getAllDepartment();
        assert result.size() == 2;
    }
}
