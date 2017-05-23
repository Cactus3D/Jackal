package com.suglobov.jackal.justice.service.impl;

import com.suglobov.jackal.justice.service.CompileService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class CompileServiceImpl implements CompileService {

    private final List<String> args;

    public CompileServiceImpl(String... args) {
        this.args = new LinkedList<>();
        this.args.addAll(Arrays.asList(args));
    }

    /**
     * Compile users cpp files to test.exe
     *
     * @param files files to compile
     * @return error log, if it would be or message "Compile complete"
     * @throws IOException if smth go wrong with compiler
     */
    @Override
    public String compile(File[] files) throws IOException {
        for (File file :
                files) {
            this.args.add(file.getCanonicalPath());
        }
        String filepath = files[0].getParent();
        this.args.add("-o");
        this.args.add(filepath + "test.exe");

        Process process = new ProcessBuilder(this.args).start();

        InputStream er = process.getErrorStream();
        InputStream is = process.getInputStream();
        InputStreamReader err = new InputStreamReader(er);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader ber = new BufferedReader(err);
        BufferedReader br = new BufferedReader(isr);

        String line;
        StringBuilder builder = new StringBuilder();

        boolean isFault = false;

        while ((line = ber.readLine()) != null) {
            line = line + '\n';
            builder.append(line);
            isFault = true;
        }
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        if (!isFault) {
            builder = new StringBuilder("COMPLETE");
        }
        return builder.toString();
    }

    /**
     * Compile users cpp files to test.exe
     *
     * @param path path to files directory
     * @param args array of files, which need to be compile
     * @return error log, if it would be or message "Compile complete"
     * @throws IOException if smth go wrong with compiler
     */
    @Override
    @Deprecated
    public String compile(Path path, String... args) throws IOException {
        String filepath = path.toString();
        for (String arg :
                args) {
            this.args.add(filepath + arg);
        }
        this.args.add("-o");
        this.args.add(filepath + "test.exe");

        Process process = new ProcessBuilder(this.args).start();

        InputStream er = process.getErrorStream();
        InputStream is = process.getInputStream();
        InputStreamReader err = new InputStreamReader(er);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader ber = new BufferedReader(err);
        BufferedReader br = new BufferedReader(isr);

        String line;
        //String title = "Compile";
        StringBuilder message = new StringBuilder();

        boolean isFault = false;

        while ((line = ber.readLine()) != null) {
            message.append(line + '\n');
            isFault = true;
        }
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        if (!isFault) {
            message = new StringBuilder("Compile complete");
        }
        return message.toString();
    }

    @Override
    public void setArgs(String... args) {
        this.args.addAll(Arrays.asList(args));
    }
}
