package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.UserRole;
import com.suglobov.jackal.database.repository.UserRoleRepository;
import com.suglobov.jackal.database.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cactus3D
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole addUserRole(UserRole role) {
        return userRoleRepository.saveAndFlush(role);
    }

    @Override
    public void delete(int id) {
        userRoleRepository.delete(id);
    }

    @Override
    public UserRole editUserRole(UserRole role) {
        return userRoleRepository.saveAndFlush(role);
    }

    @Override
    public UserRole getByName(String name) {
        return userRoleRepository.findByName(name);
    }

    @Override
    public UserRole getById(int id) {
        return userRoleRepository.findOne(id);
    }

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }
}
