package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cactus3D
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
