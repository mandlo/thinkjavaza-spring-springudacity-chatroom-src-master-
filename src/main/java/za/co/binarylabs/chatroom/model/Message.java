package za.co.binarylabs.chatroom.model;

/**
 * Created by prisca on 2019/08/05.
 */
public class Message {

    private String userName;

    private String content;

    private static Long numberOfUsers = 0l;

    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, ENTER
    }

    public Message() {
    }

    public Message(String userName) {
        this.userName = userName;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }

    public String getUserName() {
        return userName;
    }

    public void setuserName(String name) {
        this.userName = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Long getNumberOfUsers() {
        return numberOfUsers;
    }

    public static void setNumberOfUsers(Long numberOfUsers) {
        Message.numberOfUsers = numberOfUsers;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
