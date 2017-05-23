package com.suglobov.jackal.justice.service;

/**
 * @author Cactus3D
 */
public interface QueueManagerService {
    CandidateService getNext();

    CandidateService[] getAll();

    int getCount();

    void addToQueue(CandidateService candidate);
}
