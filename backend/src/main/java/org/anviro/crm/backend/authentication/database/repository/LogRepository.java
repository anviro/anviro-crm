package org.anviro.crm.backend.authentication.database.repository;

import org.anviro.crm.backend.authentication.database.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
