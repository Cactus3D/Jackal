package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.Student;
import com.suglobov.jackal.database.entity.Task;
import com.suglobov.jackal.database.entity.Try;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
public interface TryService {
    Try addTry(Try _try);

    Try editTry(Try _try);

    void delete(int id);

    Try getById(int id);

    List<Try> getAll();

    List<Try> getFromStudent(Student student);

    List<Try> getWithTask(Task task);

    List<Try> getFromStudentWithTask(Student student, Task task);
}
