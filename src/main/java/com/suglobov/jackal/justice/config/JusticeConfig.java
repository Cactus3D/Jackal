package com.suglobov.jackal.justice.config;

import com.suglobov.jackal.justice.service.CompileService;
import com.suglobov.jackal.justice.service.QueueManagerService;
import com.suglobov.jackal.justice.service.ReportService;
import com.suglobov.jackal.justice.service.impl.CompileServiceImpl;
import com.suglobov.jackal.justice.service.impl.QueueManagerServiceImpl;
import com.suglobov.jackal.justice.service.impl.ReportServiceImpl;
import com.suglobov.jackal.justice.thread.JusticeThread;
import com.suglobov.jackal.salvage.service.UtilStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Cactus3D
 */
@Configuration
@ComponentScan("com.suglobov.jackal.justice")
@PropertySource("classpath:application.properties")
public class JusticeConfig {

    private static final String PROP_JUSTICE_COMPILER_ARGS = "justice.compiler.args";

    private static JusticeThread thread;
    private UtilStorageService utilStorageService;

    @Autowired
    public void utilStorageService(UtilStorageService utilStorageService){
        this.utilStorageService = utilStorageService;
    }

    @Bean
    public JusticeThread justiceThread() {
        if(thread == null){
            thread = new JusticeThread(
                    queueManagerService(),
                    queueManagerService(),
                    queueManagerService());
            thread.start();
        }
        return thread;
    }

    @Bean
    @Primary
    public QueueManagerService queueManagerService() {
        return new QueueManagerServiceImpl();
    }

    @Bean
    public CompileService compileService() {
        CompileService compileService = new CompileServiceImpl();
        ArrayList<String> args = new ArrayList<>();
        args.add(utilStorageService.getCompiler());
        Collections.addAll(args, PROP_JUSTICE_COMPILER_ARGS.split(","));
        String[] properties = new String[args.size()];
        properties = args.toArray(properties);
        compileService.setArgs(properties);
        return compileService;
    }

    @Bean
    @Primary
    public ReportService reportService() {
        return new ReportServiceImpl();
    }
}
