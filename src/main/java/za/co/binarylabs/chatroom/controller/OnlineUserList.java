package za.co.binarylabs.chatroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.binarylabs.chatroom.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prisca on 2019/08/07.
 */
@Controller
public class OnlineUserList {

    @RequestMapping("/userlist")
    public String list(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Tom"));
        userList.add(new User("Jerry"));
        userList.add(new User("Paul"));
        model.addAttribute("userList", userList);
        return "userList"; //userList.html
    }
}
