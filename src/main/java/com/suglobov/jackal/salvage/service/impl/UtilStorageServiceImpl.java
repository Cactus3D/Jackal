package com.suglobov.jackal.salvage.service.impl;

import com.suglobov.jackal.salvage.logistic.CompilerStorageProperties;
import com.suglobov.jackal.salvage.service.UtilStorageService;
import org.springframework.stereotype.Service;

/**
 * @author Cactus3D
 */
@Service
public class UtilStorageServiceImpl implements UtilStorageService{

    private final String compilerLocation;

    public UtilStorageServiceImpl(CompilerStorageProperties propertiesStorage){
        compilerLocation = propertiesStorage.getLocation();
    }

    @Override
    public String getCompiler() {
        return compilerLocation;
    }
}
