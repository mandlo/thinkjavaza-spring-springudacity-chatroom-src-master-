package za.co.binarylabs.chatroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by prisca on 2019/08/06.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
     return "login";//the view
    }
}
