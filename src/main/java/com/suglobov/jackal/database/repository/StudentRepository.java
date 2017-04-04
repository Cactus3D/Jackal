package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByGroup(Group group);
}
