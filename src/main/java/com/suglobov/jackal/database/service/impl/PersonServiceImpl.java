package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.Person;
import com.suglobov.jackal.database.entity.Student;
import com.suglobov.jackal.database.repository.PersonRepository;
import com.suglobov.jackal.database.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cactus3D
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        return personRepository.saveAndFlush(person);
    }

    @Override
    public Person editPerson(Person person) {
        return personRepository.saveAndFlush(person);
    }

    @Override
    public void delete(int id) {
        personRepository.delete(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(int id) {
        return personRepository.findOne(id);
    }
}
