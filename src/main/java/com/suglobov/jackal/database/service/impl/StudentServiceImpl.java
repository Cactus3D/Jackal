package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.Student;
import com.suglobov.jackal.database.repository.StudentRepository;
import com.suglobov.jackal.database.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        Student savedStudent = studentRepository.saveAndFlush(student);
        return savedStudent;
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.findOne(id);
    }

    @Override
    public List<Student> getInGroup(Group group) {
        return studentRepository.findByGroup(group);
    }
}
