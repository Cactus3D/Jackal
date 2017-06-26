package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.Group;
import com.suglobov.jackal.database.entity.LinkGroupStudent;
import com.suglobov.jackal.database.entity.Person;

import java.util.List;

/**
 * @author Cactus3D
 */
public interface LinkGroupStudentService {

    LinkGroupStudent addLink(LinkGroupStudent link);

    void delete(int id);

    LinkGroupStudent editLink(LinkGroupStudent link);

    List<LinkGroupStudent> getByVariant(int variant);

    LinkGroupStudent getById(int id);

    LinkGroupStudent getByStudent(Person person);

    List<LinkGroupStudent> getAll();

    List<LinkGroupStudent> getByGroup(Group group);
}
