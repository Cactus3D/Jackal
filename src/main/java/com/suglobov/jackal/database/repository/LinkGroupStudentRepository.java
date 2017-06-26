package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.LinkGroupStudent;
import com.suglobov.jackal.database.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Cactus3D
 */
public interface LinkGroupStudentRepository extends JpaRepository<LinkGroupStudent, Integer> {
    List<LinkGroupStudent> findByVariant(int variant);
    List<LinkGroupStudent> findByGroup(Group group);
    LinkGroupStudent findByStudent(Person person);
}
