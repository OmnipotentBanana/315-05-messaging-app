package com.npg005.message;
import java.time.LocalDateTime;

public class Message {
    private String message;
    private LocalDateTime timeSent;

    public Message(String message, LocalDateTime timeSent) {
        this.message = message;
        this.timeSent = timeSent;
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
}
