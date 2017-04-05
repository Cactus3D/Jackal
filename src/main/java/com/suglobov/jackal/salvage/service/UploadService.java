package com.suglobov.jackal.salvage.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    void init();
    void store(MultipartFile file, int id);
}
