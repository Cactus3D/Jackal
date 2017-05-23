package com.suglobov.jackal.justice.thread.strategy;

import com.suglobov.jackal.justice.service.CandidateService;
import com.suglobov.jackal.justice.thread.JusticeThread;

/**
 * @author Cactus3D
 */
public class TestStrategy implements Runnable {

    private final CandidateService candidate;
    private final JusticeThread mainThread;
    private final int MAX_TIMEOUT;

    public TestStrategy(CandidateService candidate, JusticeThread mainThread, int MAX_TIMEOUT) {
        this.candidate = candidate;
        this.mainThread = mainThread;
        this.MAX_TIMEOUT = MAX_TIMEOUT;
    }

    @Override
    public void run() {
        //Logic
    }
}
