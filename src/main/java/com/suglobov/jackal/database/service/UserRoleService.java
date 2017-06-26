package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.UserRole;

import java.util.List;

/**
 * @author Cactus3D
 */
public interface UserRoleService {

    UserRole addUserRole(UserRole role);

    void delete(int id);

    UserRole editUserRole(UserRole role);

    UserRole getByName(String name);

    UserRole getById(int id);

    List<UserRole> getAll();
}
