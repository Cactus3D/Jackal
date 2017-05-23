package com.suglobov.jackal.justice.service.impl;

import com.suglobov.jackal.justice.service.CandidateService;
import com.suglobov.jackal.justice.service.QueueManagerService;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Cactus3D
 */
@Service
public class QueueManagerServiceImpl implements QueueManagerService {

    private Queue<CandidateService> queue;

    public QueueManagerServiceImpl() {
        queue = new LinkedBlockingQueue<>();
    }

    public QueueManagerServiceImpl(Queue<CandidateService> queue) {
        this.queue = queue;
    }

    @Override
    public CandidateService getNext() {
        return queue.poll();
    }

    @Override
    public CandidateService[] getAll() {
        return (CandidateService[]) queue.toArray();
    }

    @Override
    public int getCount() {
        return queue.size();
    }

    @Override
    public void addToQueue(CandidateService candidate) {
        queue.add(candidate);
    }
}
