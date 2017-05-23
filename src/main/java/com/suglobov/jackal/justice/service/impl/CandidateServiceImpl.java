package com.suglobov.jackal.justice.service.impl;

import com.suglobov.jackal.justice.service.CandidateService;
import com.suglobov.jackal.justice.service.ReportService;
import com.suglobov.jackal.justice.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cactus3D
 */
@Service
public class CandidateServiceImpl implements CandidateService {

    private int tryID;
    private int taskID;
    private int variantID;
    private ReportService report;

    @Autowired
    public CandidateServiceImpl(ReportService report) {
        this.report = report;
    }

    @Override
    public int getTryID() {
        return tryID;
    }

    @Override
    public int getTaskID() {
        return taskID;
    }

    @Override
    public int getVariantID() {
        return variantID;
    }

    @Override
    public String getReport() {
        return report.toString();
    }

    @Override
    public void setParameters(int tryID, int taskID, int variantID) {
        this.tryID = tryID;
        this.taskID = taskID;
        this.variantID = variantID;
    }

    @Override
    public void addMessage(Message message) {
        report.addMessage(message);
    }
}
