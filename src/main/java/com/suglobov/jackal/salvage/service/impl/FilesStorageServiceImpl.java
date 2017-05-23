package com.suglobov.jackal.salvage.service.impl;

import com.suglobov.jackal.salvage.logistic.TaskStorageProperties;
import com.suglobov.jackal.salvage.logistic.TriesStorageProperties;
import com.suglobov.jackal.salvage.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

    private final String rootLocationTries;
    private final String rootLocationTasks;

    @Autowired
    public FilesStorageServiceImpl(TriesStorageProperties propertiesTries, TaskStorageProperties propertiesTask) {
        rootLocationTries = propertiesTries.getLocation();
        rootLocationTasks = propertiesTask.getLocation();
    }

    @Override
    public File[] getFilesByID(int id) {
        File dir = new File(rootLocationTries + "//" + id + "//");
        return dir.listFiles((_dir, _name) -> _name.endsWith(".cpp"));
    }

    @Override
    public File[] getTestingFilesByID(int id, int variantID) {
        File dir = new File(rootLocationTasks + "//" + id + "//" + variantID + "//tests//");
        return dir.listFiles();
    }

    @Override
    public void saveFiles(File[] files, int id) {

    }

    @Override
    public void saveTests(File[] files, int id, int variantID) {

    }
}
