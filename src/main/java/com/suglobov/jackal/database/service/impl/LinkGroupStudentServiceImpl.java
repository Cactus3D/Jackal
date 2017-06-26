package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.LinkGroupStudent;
import com.suglobov.jackal.database.entity.Person;
import com.suglobov.jackal.database.repository.LinkGroupStudentRepository;
import com.suglobov.jackal.database.service.LinkGroupStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cactus3D
 */
@Service
public class LinkGroupStudentServiceImpl implements LinkGroupStudentService{

    @Autowired
    private LinkGroupStudentRepository linkGroupStudentRepository;

    @Override
    public LinkGroupStudent addLink(LinkGroupStudent link) {
        LinkGroupStudent savedLinkGroupStudent = linkGroupStudentRepository.saveAndFlush(link);
        return savedLinkGroupStudent;
    }

    @Override
    public void delete(int id) {
        linkGroupStudentRepository.delete(id);
    }

    @Override
    public List<LinkGroupStudent> getByVariant(int variant) {
        return linkGroupStudentRepository.findByVariant(variant);
    }

    @Override
    public LinkGroupStudent editLink(LinkGroupStudent link) {
        return linkGroupStudentRepository.saveAndFlush(link);
    }

    @Override
    public LinkGroupStudent getById(int id) {
        return linkGroupStudentRepository.findOne(id);
    }

    @Override
    public LinkGroupStudent getByStudent(Person person) {
        return linkGroupStudentRepository.findByStudent(person);
    }

    @Override
    public List<LinkGroupStudent> getAll() {
        return linkGroupStudentRepository.findAll();
    }

    @Override
    public List<LinkGroupStudent> getByGroup(Group group) {
        return linkGroupStudentRepository.findByGroup(group);
    }
}
