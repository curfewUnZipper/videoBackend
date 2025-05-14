package com.example.videocall.controller;

import com.example.videocall.model.SignalMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SignalingController {

    private final SimpMessagingTemplate messagingTemplate;

    // Constructor injection of SimpMessagingTemplate
    public SignalingController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Handles incoming signaling messages
    @MessageMapping("/signal")
    public void handleSignal(SignalMessage message) {
        // Send the message to the /topic/signal destination
        messagingTemplate.convertAndSend("/topic/signal", message);
    }
}
