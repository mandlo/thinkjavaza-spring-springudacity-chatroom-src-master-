package za.co.binarylabs.chatroom.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by prisca on 2019/08/05.
 */

public class Message {

    @NotEmpty(message = "username cannot be empty")
    @NotNull
    private String userName;

    private String content;

    private static AtomicLong onlineCount = new AtomicLong(0);

    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, ENTER
    }

    public Message() {
      onlineCount.incrementAndGet();
    }

    public Message(String userName) {
        this.userName = userName;
        onlineCount.incrementAndGet();
    }

    public Message(String userName, String content) {
        this.userName = userName;
        this.content = content;
        onlineCount.incrementAndGet();
    }

    public Message(String userName, String content, MessageType type) {
        this.userName = userName;
        this.content = content;
        this.type = type;
        onlineCount.incrementAndGet();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public AtomicLong getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(AtomicLong onlineCount) {
        this.onlineCount = onlineCount;
    }
}
