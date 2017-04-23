package com.suglobov.jackal.justice.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Cactus3D on 23.04.2017.
 */
public class QueueManager {

    private static Queue<Candidate> queue = new LinkedBlockingQueue<>();

    public static Candidate getNext() {
        return queue.poll();
    }

    public static Candidate[] getAll() {
        return (Candidate[])queue.toArray();
    }

    public static int getCount() {
        return queue.size();
    }

    public static void addToQueue(Candidate candidate) {
        queue.add(candidate);
    }
}
