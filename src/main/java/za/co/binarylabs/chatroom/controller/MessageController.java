package za.co.binarylabs.chatroom.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import za.co.binarylabs.chatroom.model.Message;
import za.co.binarylabs.chatroom.model.MessageWrapper;

/**
 * Created by prisca on 2019/08/13.
 */
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageWrapper send(Message message) {
        return new MessageWrapper(message.getUserName(), message.getContent());
    }

}
