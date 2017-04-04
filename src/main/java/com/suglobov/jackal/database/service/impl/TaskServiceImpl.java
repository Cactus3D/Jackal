package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.Task;
import com.suglobov.jackal.database.repository.TaskRepository;
import com.suglobov.jackal.database.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        Task savedTask = taskRepository.saveAndFlush(task);
        return savedTask;
    }

    @Override
    public Task editTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public void delete(int id) {
        taskRepository.delete(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(int id) {
        return taskRepository.findOne(id);
    }

    @Override
    public Task getByName(String name) {
        return taskRepository.findByName(name);
    }
}
