package com.suglobov.jackal.rest.model;

public class Main {

    private final long id;
    private final String content;

    public Main(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
