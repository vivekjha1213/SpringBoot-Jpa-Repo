package com.springBoot.Advanced.Controller;

import com.springBoot.Advanced.entity.Department;
import com.springBoot.Advanced.error.DepartmentNotFoundException;
import com.springBoot.Advanced.service.DepartmentService;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){

        LOGGER.info("inside save department ");

      return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){

        LOGGER.info("inside fetch all department ");
        return departmentService.fetchDepartmentList();


    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        LOGGER.info("inside fetch department by Id ");

        return  departmentService.fetchDepartmentById(departmentId);
    }


    @DeleteMapping("/departments/{id}")
    public  String deleteDepartmentById(@PathVariable("id") Long departmentId){


        LOGGER.info("delete department  ");
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public  Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){

        LOGGER.info("inside update department ");
        return departmentService.updateDepartment(departmentId,department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.fetchDepartmentByName(departmentName);
    }

}