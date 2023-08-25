package com.dev.dto;

public class FindDisLikesDto {
    
    private String userId;
    private int postNum;

    public FindDisLikesDto(String userId, int postNum) {
        this.userId = userId;
        this.postNum = postNum;
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
