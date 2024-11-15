package com.project.ChatApplication.controller;

import com.project.ChatApplication.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("These is client id"+ message.getClientId()+" These is message"+message.getContent());
        return message;  // Sends the message to be broadcast to everyone subscribed
    }
}