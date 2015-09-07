package org.anviro.crm.backend.another.database.dbservice;

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

    public DepartmentBean getDeparment(Long id) {
        Department dbDepartment = departmentRepository.findOne(id);
        return Utils.createDepartmentBean(dbDepartment);
    }

    public DepartmentBean getDeparment(String name) {
        Department dbDepartment = departmentRepository.findByName(name);
        return Utils.createDepartmentBean(dbDepartment);
    }

    @Transactional
    public boolean addDepartment(DepartmentBean department) {
        Department dbDepartment = departmentRepository.findByName(department.getName());

        if (dbDepartment == null) {
            Department newDepartment = new Department(department.getName(), department.getAddress(),
                    department.getPhone());
            departmentRepository.saveAndFlush(newDepartment);
            return true;
        }

        return false;
    }

    @Transactional
    public void updateDepartment(DepartmentBean department) {
        Department dbDepartment = departmentRepository.findOne(department.getId());
        dbDepartment.setAddress(department.getAddress());
        dbDepartment.setName(department.getName());
        dbDepartment.setPhone(department.getPhone());
        departmentRepository.saveAndFlush(dbDepartment);
    }

    @Transactional
    public void removeDepartment(Long id) {
        departmentRepository.delete(id);
    }
}
