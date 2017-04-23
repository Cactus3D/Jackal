package com.suglobov.jackal.justice.service;

/**
 * Created by Cactus3D on 23.04.2017.
 */
public interface QueueManagerService {
    int getNext();
    int[] getAll();
    int getCount();
    void addToQueue(int id);
}
