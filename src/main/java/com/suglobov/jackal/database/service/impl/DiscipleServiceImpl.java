package com.suglobov.jackal.database.service.impl;

import com.suglobov.jackal.database.entity.Disciple;
import com.suglobov.jackal.database.entity.Disciple;
import com.suglobov.jackal.database.repository.DiscipleRepository;
import com.suglobov.jackal.database.repository.DiscipleRepository;
import com.suglobov.jackal.database.service.DiscipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cactus3D
 */
@Service
public class DiscipleServiceImpl implements DiscipleService {

    @Autowired
    private DiscipleRepository DiscipleRepository;

    @Override
    public Disciple addDisciple(Disciple Disciple) {
        Disciple savedDisciple = DiscipleRepository.saveAndFlush(Disciple);
        return savedDisciple;
    }

    @Override
    public void delete(int id) {
        DiscipleRepository.delete(id);
    }

    @Override
    public Disciple editDisciple(Disciple Disciple) {
        return DiscipleRepository.saveAndFlush(Disciple);
    }

    @Override
    public Disciple getById(int id) {
        return DiscipleRepository.findOne(id);
    }

    @Override
    public List<Disciple> getAll() {
        return DiscipleRepository.findAll();
    }
}
