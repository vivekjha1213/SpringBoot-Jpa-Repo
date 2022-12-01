package com.springBoot.Advanced.repository;

import com.springBoot.Advanced.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private  DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department=
                Department.builder()
                        .departmentName("Mech")
                        .departmentCode("001")
                        .departmentAddress("SRM").build();

        entityManager.persist(department);

    }


    @Test
    public  void whenFindById_ThenReturnDepartment(){

        Department department= departmentRepository.findById(1l).get();
        assertEquals(department.getDepartmentName(),"Mech");
    }
}