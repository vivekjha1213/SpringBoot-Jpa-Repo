package com.springBoot.Advanced.service;

import com.springBoot.Advanced.entity.Department;
import com.springBoot.Advanced.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {



    @Autowired
    private  DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department=Department.builder()
                .departmentName("IT")
                .departmentAddress("SRM")
                .departmentCode("001")
                .departmentId(1L)
                .build();


        Mockito.when(departmentRepository.findByDepartmentName("IT")).
                thenReturn(department);
    }

    @Test
    @DisplayName("Get Data  based on valid ")
    @Disabled
    public void whenValidDepartmentName_ThenDepartmentShouldBeFound(){

        String departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());

    }
}