package za.co.binarylabs.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import za.co.binarylabs.chatroom.model.Message;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@RestController
@SpringBootApplication
public class ChatroomApplication {

	@Autowired
	Message msg;

	public static void main(String[] args) {
		SpringApplication.run(ChatroomApplication.class, args);
	}

	/**
	 * Login Page
	 */
	@GetMapping
	public ModelAndView login() {
		return new ModelAndView("/login");
	}

	/**
	 * Chatroom Page
	 */
	@GetMapping("/index")
	public ModelAndView index(String username, HttpServletRequest request)
			throws UnknownHostException {
		//TODO: add code for login to chatroom.
		//Comment from Reviewer - Here you could add your check test for anonymity.
		ModelAndView mv = new ModelAndView("/chat");

		if (request.getRemoteUser() != null) {
			mv.addObject("userName", username);
			return mv;
		}
		return null;
	}
}


