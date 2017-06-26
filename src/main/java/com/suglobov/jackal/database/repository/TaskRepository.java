package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Disciple;
import com.suglobov.jackal.database.entity.Person;
import com.suglobov.jackal.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByName(String name);
    List<Task> findByAuthor (Person person);
    List<Task> findByDisciple (Disciple disciple);
}
