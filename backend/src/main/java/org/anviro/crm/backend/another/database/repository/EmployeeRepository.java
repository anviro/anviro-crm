package org.anviro.crm.backend.another.database.repository;

import org.anviro.crm.backend.another.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
