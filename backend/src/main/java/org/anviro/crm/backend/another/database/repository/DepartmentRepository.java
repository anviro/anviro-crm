package org.anviro.crm.backend.another.database.repository;

import org.anviro.crm.backend.another.database.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);
}
