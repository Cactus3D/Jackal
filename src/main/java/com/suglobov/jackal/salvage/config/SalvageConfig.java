package com.suglobov.jackal.salvage.config;

import com.suglobov.jackal.salvage.logistic.CompilerStorageProperties;
import com.suglobov.jackal.salvage.logistic.RootStorageProperties;
import com.suglobov.jackal.salvage.logistic.TaskStorageProperties;
import com.suglobov.jackal.salvage.logistic.TriesStorageProperties;
import com.suglobov.jackal.salvage.service.FilesStorageService;
import com.suglobov.jackal.salvage.service.UploadService;
import com.suglobov.jackal.salvage.service.impl.FilesStorageServiceImpl;
import com.suglobov.jackal.salvage.service.impl.UploadServiceImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.suglobov.jackal.salvage")
@PropertySource("classpath:application.properties")
public class SalvageConfig {

    private static final String PROP_STORAGE_ROOTPATH = "storage.rootpath";
    private static final String PROP_STORAGE_TRIES_PATH = "storage.tries.path";
    private static final String PROP_STORAGE_TASKS_PATH = "storage.tasks.path";
    private static final String PROP_STORAGE_COMPILER_PATH = "storage.compiler.path";

    @Bean
    public RootStorageProperties rootStorageProperties() {
        RootStorageProperties rootStorageProperties = new RootStorageProperties();
        rootStorageProperties.setLocation(PROP_STORAGE_ROOTPATH);
        return rootStorageProperties;
    }

    @Bean
    public TriesStorageProperties triesStorageProperties() {
        TriesStorageProperties triesStorageProperties = new TriesStorageProperties();
        triesStorageProperties.setLocation(PROP_STORAGE_TRIES_PATH);
        return triesStorageProperties;
    }

    @Bean
    public TaskStorageProperties taskStorageProperties() {
        TaskStorageProperties taskStorageProperties = new TaskStorageProperties();
        taskStorageProperties.setLocation(PROP_STORAGE_TASKS_PATH);
        return taskStorageProperties;
    }

    @Bean
    public CompilerStorageProperties compilerStorageProperties() {
        CompilerStorageProperties compilerStorageProperties = new CompilerStorageProperties();
        compilerStorageProperties.setLocation(PROP_STORAGE_COMPILER_PATH);
        return compilerStorageProperties;
    }

    @Bean
    @Primary
    public UploadService uploadService() {
        return new UploadServiceImpl(new TriesStorageProperties());
    }

    @Bean
    @Primary
    public FilesStorageService testingService() {
        return new FilesStorageServiceImpl(new TriesStorageProperties(), new TaskStorageProperties());
    }
}
