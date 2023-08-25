package com.dev.dto;

public class LikesDto {

    private String userId;
    private int postNum;

    LikesDto(){}
    public LikesDto(String userId, int postId) {
        this.userId = userId;
        this.postNum = postId;
    }

    public String getUserId() {
        return userId;
    }

    public int getPostNum() {
        return postNum;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }
}
