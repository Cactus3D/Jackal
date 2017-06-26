package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cactus3D
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
