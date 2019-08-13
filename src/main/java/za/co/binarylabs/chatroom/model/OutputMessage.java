package za.co.binarylabs.chatroom.model;

/**
 * Created by prisca on 2019/08/13.
 */
public class OutputMessage {
    private String user;
    private String content;

    public OutputMessage(final String user, final String content) {
        this.user = user;
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}
