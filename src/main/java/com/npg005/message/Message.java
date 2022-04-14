package com.npg005.message;
import com.npg005.user.User;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String message;
    private LocalDateTime timeSent;
    private User user;

    public Message(String message, LocalDateTime timeSent, User user) {
        this.message = message;
        this.timeSent = timeSent;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
