package org.anviro.crm.backend.authentication.database.repository;

import org.anviro.crm.backend.authentication.database.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
