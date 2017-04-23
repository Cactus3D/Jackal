package com.suglobov.jackal.justice.util;

/**
 * Created by Cactus3D on 23.04.2017.
 */
public class Candidate {
    private int tryID;
    private int taskID;
    private Report report;

    public Candidate(int tryID, int taskID) {
        this.tryID = tryID;
        this.taskID = taskID;
        report = new Report();
    }

    public Candidate(int tryID, int taskID, Report report) {
        this.tryID = tryID;
        this.taskID = taskID;
        this.report = report;
    }

    public int getTryID() {
        return tryID;
    }

    public void setTryID(int tryID) {
        this.tryID = tryID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "ID = " + tryID +
                ", report=" + report.toString() +
                '}';
    }
}
