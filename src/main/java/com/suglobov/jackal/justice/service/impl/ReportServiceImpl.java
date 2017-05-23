package com.suglobov.jackal.justice.service.impl;

import com.suglobov.jackal.justice.service.ReportService;
import com.suglobov.jackal.justice.util.Message;
import com.suglobov.jackal.justice.util.Status;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * @author Cactus3D
 */
@Service
public class ReportServiceImpl implements ReportService {

    private LinkedList<Message> messages = new LinkedList<>();

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void setMessages(LinkedList<Message> messages) {
        this.messages = messages;
    }

    public Status getStatus() {
        return messages.getLast().getStatus();
    }

    public Message getLastMessage() {
        return messages.getLast();
    }

    @Override
    public String toString() {
        String result = "Report{";
        for (Message message :
                messages) {
            result += message.toString();
        }
        result += "}";
        return result;
    }

    @Override
    public void addMessage(Message message) {
        messages.add(message);
    }
}
