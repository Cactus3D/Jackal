package com.suglobov.jackal.salvage.service.impl;

import com.suglobov.jackal.salvage.exception.StorageException;
import com.suglobov.jackal.salvage.logistic.TriesStorageProperties;
import com.suglobov.jackal.salvage.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class UploadServiceImpl implements UploadService {

    private final String rootLocation;

    @Autowired
    public UploadServiceImpl(TriesStorageProperties properties) {
        this.rootLocation = properties.getLocation();
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(Paths.get(rootLocation));
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file, int id) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            Path path = Paths.get(rootLocation + '\\'+id);
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
}
