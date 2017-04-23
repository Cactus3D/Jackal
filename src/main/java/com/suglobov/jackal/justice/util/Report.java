package com.suglobov.jackal.justice.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Cactus3D on 23.04.2017.
 */
public class Report {

    private LinkedList<Message> messages = new LinkedList<>();

    public Report() {
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void setMessages(LinkedList<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public Status getStatus(){
        return messages.getLast().getStatus();
    }

    public Message getLastMessage(){
        return messages.getLast();
    }

    @Override
    public String toString() {
        String result = "Report{";
        for (Message message:
             messages) {
            result += message.toString();
        }
        result+="}";
        return result;
    }
}
