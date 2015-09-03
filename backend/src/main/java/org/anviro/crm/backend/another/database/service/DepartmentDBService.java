package org.anviro.crm.backend.another.database.service;

import org.anviro.crm.backend.another.Utils;
import org.anviro.crm.backend.another.database.entity.Department;
import org.anviro.crm.backend.another.database.repository.DepartmentRepository;
import org.anviro.crm.common.beans.another.DepartmentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentDBService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentBean> getDepartments() {
        List<Department> dbDepartments = departmentRepository.findAll();
        List<DepartmentBean> departments = new ArrayList<>();
        for (Department department: dbDepartments) {
            departments.add(Utils.createDepartmentBean(department));
        }
        return departments;
    }

    @Transactional
    public boolean addDepartment(DepartmentBean department) {
        Department dbDepartment = departmentRepository.findByName(department.getName());

        if (dbDepartment == null) {
            Department newDepartment = new Department(department.getName(), department.getAddress(),
                    department.getPhone());
            departmentRepository.save(newDepartment);
            return true;
        }

        return false;
    }


}
