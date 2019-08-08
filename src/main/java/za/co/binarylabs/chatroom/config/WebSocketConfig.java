package za.co.binarylabs.chatroom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import za.co.binarylabs.chatroom.model.Message;

/**
 * Created by prisca on 2019/08/05.
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public Message message() {
        return new Message();
    }
}
