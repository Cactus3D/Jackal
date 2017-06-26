package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.Person;
import com.suglobov.jackal.database.entity.Student;
import com.suglobov.jackal.database.entity.Task;
import com.suglobov.jackal.database.entity.Try;
import com.suglobov.jackal.database.repository.TryRepository;
import com.suglobov.jackal.database.service.TryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
@Service
public class TryServiceImpl implements TryService {

    @Autowired
    private TryRepository tryRepository;

    @Override
    public Try addTry(Try _try) {
        Try savedTry = tryRepository.saveAndFlush(_try);
        return savedTry;
    }

    @Override
    public Try editTry(Try _try) {
        return tryRepository.saveAndFlush(_try);
    }

    @Override
    public void delete(int id) {
        tryRepository.delete(id);
    }

    @Override
    public Try getById(int id) {
        return tryRepository.findOne(id);
    }

    @Override
    public List<Try> getAll() {
        return tryRepository.findAll();
    }

    @Override
    public List<Try> getFromStudent(Person student) {
        return tryRepository.findByPerson(student);
    }

    @Override
    public List<Try> getWithTask(Task task) {
        return tryRepository.findByTask(task);
    }

    @Override
    public List<Try> getFromStudentWithTask(Person student, Task task) {
        return tryRepository.findByPersonAndTask(student, task);
    }
}
