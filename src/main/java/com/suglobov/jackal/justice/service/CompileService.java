package com.suglobov.jackal.justice.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface CompileService {
    public String compile(File[] files) throws IOException;

    @Deprecated
    public String compile(Path path, String... args) throws IOException;

    public void setArgs(String... args);
}
