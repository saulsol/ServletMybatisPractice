package com.dev.dto;

public class UserLoginDto {

    private String userId;
    private String userPass;

    public UserLoginDto(){}

    public UserLoginDto(String userId, String userPass) {
        this.userId = userId;
        this.userPass = userPass;
    }


    public String getUserId() {
        return userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
