package com.npg005.message;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String username;
    private String message;
    private LocalDateTime timeSent;


    public Message(String username, String message, LocalDateTime timeSent) {
        this.username = username;
        this.message = message;
        this.timeSent = timeSent;
    }

    public Message(){

    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

