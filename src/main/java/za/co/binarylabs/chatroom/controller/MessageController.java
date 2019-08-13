package za.co.binarylabs.chatroom.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import za.co.binarylabs.chatroom.model.Message;
import za.co.binarylabs.chatroom.model.OutputMessage;

/**
 * Created by prisca on 2019/08/13.
 */
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) {
        return new OutputMessage(message.getUserName(), message.getContent());
    }

}
