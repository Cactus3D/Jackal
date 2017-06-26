package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.Person;
import com.suglobov.jackal.database.entity.Student;

import java.util.List;

/**
 * @author Cactus3D
 */
public interface PersonService {

    Person addPerson(Person person);

    Person editPerson(Person person);

    void delete(int id);

    List<Person> getAll();

    Person getById(int id);
}
