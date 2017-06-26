package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.User;

import java.util.List;

/**
 * @author Cactus3D
 */
public interface UserService {

    User addUser(User user);

    void delete(int id);

    User editUser(User user);

    User getByName(String name);

    User getById(int id);

    List<User> getAll();
}
