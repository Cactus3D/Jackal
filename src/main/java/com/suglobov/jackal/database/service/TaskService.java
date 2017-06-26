package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.Disciple;
import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.Person;
import com.suglobov.jackal.database.entity.Task;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
public interface TaskService {
    Task addTask(Task task);

    Task editTask(Task task);

    void delete(int id);

    List<Task> getAll();

    Task getById(int id);

    Task getByName(String name);

    List<Task> getByDisciple(Disciple disciple);

    List<Task> getByAuthor(Person person);

    List<Task> getByGroup(Group group);
}
