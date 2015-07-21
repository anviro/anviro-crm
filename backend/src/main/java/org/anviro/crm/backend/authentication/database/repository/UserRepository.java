package org.anviro.crm.backend.authentication.database.repository;

import org.anviro.crm.backend.authentication.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUsername(String username);

}
