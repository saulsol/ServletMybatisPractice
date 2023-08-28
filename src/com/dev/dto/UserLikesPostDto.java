package com.dev.dto;

public class UserLikesPostDto {

    private int limit;
    private int offset;
    private String userId;

    public UserLikesPostDto() {
    }

    public UserLikesPostDto(int limit, int offset, String userId) {
        this.limit = limit;
        this.offset = offset;
        this.userId = userId;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public String getUserId() {
        return userId;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
