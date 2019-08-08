package za.co.binarylabs.chatroom.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by prisca on 2019/08/08.
 */
public class User{
    @NotEmpty(message = "username cannot be empty")
    @NotNull
    private String userName;

    public User(@NotEmpty(message = "username cannot be empty") @NotNull String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
