package com.springBoot.Advanced.service;

import com.springBoot.Advanced.entity.Department;
import com.springBoot.Advanced.error.DepartmentNotFoundException;
import com.springBoot.Advanced.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department=
                departmentRepository.findById(departmentId);

        if (!department.isPresent()){

            throw new DepartmentNotFoundException("Department Not Available");
        }

        return  department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {


        Department depDb=departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName((department.getDepartmentName()));
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode((department.getDepartmentCode()));
        }



        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){

            depDb.setDepartmentAddress(department.getDepartmentAddress());


        }

   return departmentRepository.save(depDb);
}

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

}
