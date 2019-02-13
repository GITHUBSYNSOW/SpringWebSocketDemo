package com.websocket.chatapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public  ChatMessage register(@Payload ChatMessage msg, SimpMessageHeaderAccessor accessor){
        accessor.getSessionAttributes().put("username",msg.getSender());
        return msg;

    }


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage msg){
        return msg;
    }





}
