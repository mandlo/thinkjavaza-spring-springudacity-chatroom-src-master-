package za.co.binarylabs.chatroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.binarylabs.chatroom.model.Message;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by prisca on 2019/08/07.
 */
@Controller
public class OnlineUserList {

    @Autowired
    Message msg;

    @RequestMapping("/chat")
    public String list(Model model) {
        List<Message> messageList = new ArrayList<>();
        model.addAttribute("usermane", msg.getUserName());
        model.addAttribute("num", msg.getOnlineCount());
        model.addAttribute("messages", messageList);
        return "chat"; //chat.html
    }
}
