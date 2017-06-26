package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Person;
import com.suglobov.jackal.database.entity.Student;
import com.suglobov.jackal.database.entity.Task;
import com.suglobov.jackal.database.entity.Try;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
public interface TryRepository extends JpaRepository<Try, Integer> {
    List<Try> findByPerson(Person student);

    List<Try> findByTask(Task task);

    List<Try> findByPersonAndTask(Person student, Task task);
}
