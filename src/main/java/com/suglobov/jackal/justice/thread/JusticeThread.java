package com.suglobov.jackal.justice.thread;

import com.suglobov.jackal.justice.service.CandidateService;
import com.suglobov.jackal.justice.service.QueueManagerService;
import com.suglobov.jackal.justice.thread.strategy.CheckStrategy;
import com.suglobov.jackal.justice.thread.strategy.CompileStrategy;
import com.suglobov.jackal.justice.thread.strategy.TestStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Cactus3D on 22.05.2017.
 */
@Component
public class JusticeThread extends Thread {

    private final QueueManagerService toCheck;
    private final QueueManagerService toCompile;
    private final QueueManagerService toTest;

    private volatile ExecutorService checkTasks;
    private volatile ExecutorService compileTasks;
    private volatile ExecutorService testTask;

    private int MAX_CHECK_POOL = 5;
    private int MAX_COMPILE_POOL = 5;
    private int MAX_TEST_POOL = 5;
    private int MAX_TEST_TIMEOUT = 10;

    @Autowired
    public JusticeThread(QueueManagerService toCheck, QueueManagerService toCompile, QueueManagerService toTest) {
        this.toCheck = toCheck;
        this.toCompile = toCompile;
        this.toTest = toTest;

        checkTasks = Executors.newCachedThreadPool();
        compileTasks = Executors.newCachedThreadPool();
        testTask = Executors.newCachedThreadPool();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            while (toCheck.getCount() == 0 &&
                    toTest.getCount() == 0 &&
                    toCompile.getCount() == 0) {
                Thread.yield();
            }
            if (toCheck.getCount() != 0) {
                CandidateService candidate = toCheck.getNext();
                checkTasks.submit(new CheckStrategy(candidate, this));
            }
            if (toTest.getCount() != 0) {
                CandidateService candidate = toTest.getNext();
                testTask.submit(new TestStrategy(candidate, this, MAX_TEST_TIMEOUT));
            }
            if (toCompile.getCount() != 0) {
                CandidateService candidate = toCompile.getNext();
                compileTasks.submit(new CompileStrategy(candidate, this));
            }
        }
    }

    public void addToCheckQueue(CandidateService e) {
        toCheck.addToQueue(e);
    }

    public void addToCompileQueue(CandidateService e) {
        toCompile.addToQueue(e);
    }

    public void addToTestQueue(CandidateService e) {
        toTest.addToQueue(e);
    }
}
