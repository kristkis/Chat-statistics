package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Chat {
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private int id;
    @JsonProperty("messages")
    private List<Message> messages;

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for messages
    public List<Message> getMessages() {
        return messages;
    }

    // Setter for messages
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}







