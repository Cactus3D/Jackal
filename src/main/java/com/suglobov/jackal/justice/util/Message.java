package com.suglobov.jackal.justice.util;

/**
 * Created by Cactus3D on 23.04.2017.
 */
public class Message {
    private Status status;
    private String title;
    private String message;

    public Message(String title) {
        this.status = Status.IN_PROCESS;
        this.title = title;
        this.message = "";
    }

    public Message(Status status, String title, String message) {
        this.status = status;
        this.title = title;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
