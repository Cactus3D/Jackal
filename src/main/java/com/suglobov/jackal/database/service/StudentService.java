package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.Student;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
public interface StudentService {
    Student addStudent(Student student);

    Student editStudent(Student student);

    void delete(int id);

    List<Student> getAll();

    Student getById(int id);

    List<Student> getInGroup(Group group);
}
