package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.Group;

import java.util.List;

/**
 * Created by cactu on 31.03.2017.
 */
public interface GroupService {

    Group addGroup(Group group);

    void delete(int id);

    Group editGroup(Group group);

    Group getByName(String name);

    Group getById(int id);

    List<Group> getAll();
}
