package com.suglobov.jackal.salvage.service;

import java.io.File;

public interface FilesStorageService {
    File[] getFilesByID(int id);

    File[] getTestingFilesByID(int id, int variantID);

    void saveFiles(File[] files, int id);

    void saveTests(File[] files, int id, int variantID);
}
