package com.project.ChatApplication.model;

public class ChatMessage {
    private String content;
    private String clientId;

    // Constructor
    public ChatMessage() {}

    public ChatMessage(String content, String clientId) {
        this.content = content;
        this.clientId = clientId;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
