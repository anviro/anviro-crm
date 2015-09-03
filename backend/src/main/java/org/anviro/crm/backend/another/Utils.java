package org.anviro.crm.backend.another;

import org.anviro.crm.backend.another.database.entity.Department;
import org.anviro.crm.backend.another.database.entity.Employee;
import org.anviro.crm.common.beans.another.DepartmentBean;
import org.anviro.crm.common.beans.another.EmployeeBean;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    
    public static DepartmentBean createDepartmentBean(Department dep) {
        List<EmployeeBean> employees = new ArrayList<>();
        for (Employee employee: dep.getEmployees()) {
            employees.add(Utils.createEmployeeBean(employee));
        }

        return new DepartmentBean(dep.getId(), dep.getName(), dep.getAddress(),
                dep.getPhone(), employees);
    }

    public static EmployeeBean createEmployeeBean(Employee emp) {
        Department dep = emp.getDepartment();
        DepartmentBean department = new DepartmentBean(dep.getId(), dep.getName(), dep.getAddress(),
                dep.getPhone());

        return new EmployeeBean(emp.getId(), emp.getName(), emp.getDateOfBirth(), emp.getPosition(),
                emp.getPhones(), emp.getAddress(), emp.getEducation(), emp.getSalary(), department);
    }
    
}
