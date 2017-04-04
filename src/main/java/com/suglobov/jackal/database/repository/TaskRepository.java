package com.suglobov.jackal.database.repository;

import com.suglobov.jackal.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cactu on 31.03.2017.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByName(String name);
}
