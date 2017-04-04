package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.repository.GroupRepository;
import com.suglobov.jackal.database.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group addGroup(Group group) {
        Group savedGroup = groupRepository.saveAndFlush(group);
        return savedGroup;
    }

    @Override
    public void delete(int id) {
        groupRepository.delete(id);
    }

    @Override
    public Group editGroup(Group group) {
        return groupRepository.saveAndFlush(group);
    }

    @Override
    public Group getByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    public Group getById(int id) {
        return groupRepository.findOne(id);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }
}
