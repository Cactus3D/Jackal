package com.suglobov.jackal.database.service;

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
}
