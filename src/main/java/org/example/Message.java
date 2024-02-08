package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Message {

    @JsonProperty("text")
    private String text;
    public String getText() {
        return text;
    }

    @JsonProperty("from")
    private String sender;
    public String getSender() {
        return sender;
    }

    @JsonProperty("date")
    private String date;
    public String getDate() {
        return date;
    }

    @JsonProperty("sticker_emoji")
    private String emoji;
    public String getEmoji() {
        return emoji;
    }

    private Map<String, String> unrecognizedFields = new HashMap<>();

    @JsonAnySetter
    public void allSetter(String fieldName, String fieldValue) {
        unrecognizedFields.put(fieldName, fieldValue);
    }

}