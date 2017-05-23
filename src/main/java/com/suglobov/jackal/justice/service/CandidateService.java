package com.suglobov.jackal.justice.service;

import com.suglobov.jackal.justice.util.Message;

/**
 * @author Cactus3D
 */
public interface CandidateService {

    int getTryID();

    int getTaskID();

    int getVariantID();

    String getReport();

    void setParameters(int tryID, int taskID, int variantID);

    void addMessage(Message message);
}
