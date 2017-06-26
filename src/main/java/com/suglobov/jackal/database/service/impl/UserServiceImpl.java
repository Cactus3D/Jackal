package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.User;
import com.suglobov.jackal.database.repository.UserRepository;
import com.suglobov.jackal.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cactus3D
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByLogin(name);
    }

    @Override
    public User getById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
