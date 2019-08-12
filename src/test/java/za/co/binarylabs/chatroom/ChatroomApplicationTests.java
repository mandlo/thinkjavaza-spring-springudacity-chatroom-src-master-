package za.co.binarylabs.chatroom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import za.co.binarylabs.chatroom.model.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatroomApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private Message message;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void login() throws Exception {
//		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//				.andExpect(view().name("/login"));
//	}

    // The other tests should go in hear.....

}
