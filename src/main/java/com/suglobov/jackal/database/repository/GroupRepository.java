package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cactu on 31.03.2017.
 */
public interface GroupRepository extends JpaRepository<Group, Integer> {

    Group findByName(String name);
}
