package com.suglobov.jackal.justice.thread.strategy;

import com.suglobov.jackal.justice.service.CandidateService;
import com.suglobov.jackal.justice.thread.JusticeThread;

/**
 * @author Cactus3D
 */
public class CheckStrategy implements Runnable {

    private final CandidateService candidate;
    private final JusticeThread mainThread;

    public CheckStrategy(CandidateService candidate, JusticeThread mainThread) {
        this.candidate = candidate;
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        //Logic
    }
}
