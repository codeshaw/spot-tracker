package com.codeshaw.tracker.dto.spot;

import com.codeshaw.tracker.serialiser.MessageDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Messages {

    @JsonProperty("message")
    private List<Message> message = null;

    @JsonProperty("message")
    @JsonDeserialize(using = MessageDeserializer.class)
    public List<Message> getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(List<Message> message) {
        this.message = message;
    }

}