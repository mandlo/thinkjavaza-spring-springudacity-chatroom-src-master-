package za.co.binarylabs.chatroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.binarylabs.chatroom.model.Message;

import javax.websocket.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by prisca on 2019/08/05.
 */

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat/{username}")
public class WebSocketChatServer {

    private Session session;

    //All chat sessions.
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    private static Set<WebSocketChatServer> chatEndpoints = new CopyOnWriteArraySet<>();

    @Autowired
    Message message;

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userName") String userName) {
        //TODO: add on open connection.
        this.session = session;
        chatEndpoints.add(this);
        onlineSessions.put(message.getUserName(), session);

        Message message = new Message();
        message.setuserName(userName);
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) throws IOException, EncodeException {
        //TODO: add send message.
        // Handle new messages
        String userName = session.getId();
        Session ss = onlineSessions.get(userName);
        sendMessageToAll(jsonStr);
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        //TODO: add close connection.
        chatEndpoints.remove(session);
        Set<String> keys = onlineSessions.keySet();
        for(String key : keys) {
            if( key == session.getId()) {
             Session updateSession =  onlineSessions.get(key);
                message.setuserName(updateSession.getId());
            }
        }
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
        // Do error handling here
    }

    public static void sendMessageToAll(String jsonStr) throws IOException, EncodeException  {
        chatEndpoints.forEach(endPoint -> {
            synchronized (endPoint) {
              try {
                  endPoint.session.getBasicRemote()
                          .sendObject(jsonStr);
              } catch (IOException | EncodeException e) {
                  e.printStackTrace();
              }
        }
    });
    }
}
