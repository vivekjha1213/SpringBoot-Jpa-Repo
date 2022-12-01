package com.springBoot.Advanced.Controller;

import com.springBoot.Advanced.entity.Department;
import com.springBoot.Advanced.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;



    @BeforeEach
    void setUp() {

        department=Department.builder()
                .departmentAddress("SRM")
                .departmentCode("001")
                .departmentId(1L)
                .departmentName("IT")
                .build();

    }

    @Test
    void saveDepartment() {

       Department inputDepartment=Department.builder()
                .departmentAddress("SRM")
                .departmentCode("001")
                .departmentId(1L)
                .departmentName("IT")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);


    }

    @Test
    void fetchDepartmentById() {
    }
}