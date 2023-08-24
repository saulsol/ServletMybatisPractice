package com.dev.dto;

public class UserDto {


   private Long userNum;
   private String userName;
   private String userId;
   private String userPass;


    public UserDto() {}

    public UserDto(Long userNum, String userName, String userId, String userPass) {
        this.userNum = userNum;
        this.userName = userName;
        this.userId = userId;
        this.userPass = userPass;
    }

    public Long getUserNum() {
        return userNum;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
