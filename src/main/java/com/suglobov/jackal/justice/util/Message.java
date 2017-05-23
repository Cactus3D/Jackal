package com.suglobov.jackal.justice.util;

/**
 * <p>Текст сообщения о прохождении одного этапа.</p>
 * <li>
 * <ul>status - состояние этапа (завершён, ошибка, предупреждение, в процессе)</ul>
 * <ul>title - название этапа</ul>
 * <ul>message - сообщение о результате выполнения</ul>
 * </li>
 *
 * @author Cactus3D
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
        if (message.startsWith("COMPLETE"))
            status = Status.COMPLETE;
        if (message.startsWith("WARNING"))
            status = Status.WARNING;
        if (message.startsWith("ERROR"))
            status = Status.ERROR;
    }

    public boolean isCritical() {
        return status == Status.ERROR;
    }

    public void setStatusOK() {
        status = Status.COMPLETE;
    }

    public void setStatusWarning() {
        status = Status.WARNING;
    }

    public void setStatusError() {
        status = Status.ERROR;
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
