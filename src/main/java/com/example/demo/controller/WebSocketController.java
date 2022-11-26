package com.example.demo.controller;

import com.example.demo.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController
{
    @GetMapping("/webs")
    public String pingPong(){
        return "home";
    }

    @MessageMapping("/toserver")
    @SendTo("/topic/toclients")
    public Message ping(Message message){
        System.out.println(message);
        return message;
    }
}
