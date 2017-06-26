package com.suglobov.jackal.database.service;

import com.suglobov.jackal.database.entity.Disciple;

import java.util.List;

/**
 * @author Cactus3D
 */
public interface DiscipleService {

    Disciple addDisciple(Disciple disciple);

    void delete(int id);

    Disciple editDisciple(Disciple disciple);

    Disciple getById(int id);

    List<Disciple> getAll();
}
