package org.anviro.crm.backend.another.database.repository;

import org.anviro.crm.backend.another.database.entity.Department;
import org.anviro.crm.backend.another.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(Department department);

    List<Employee> findByPosition(String position);

    List<Employee> findByName(String name);

    List<Employee> findByPhone(String phone);
}
