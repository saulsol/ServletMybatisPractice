package com.dev.dto;

public class PostDto {

    private Long postNum;
    private String userId;
    private String postTitle;
    private String postContent;

    public PostDto(){}

    public PostDto(Long postNum, String userId, String postTitle, String postContent) {
        this.postNum = postNum;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public Long getPostNum() {
        return postNum;
    }

    public String getUserId() {
        return userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostNum(Long postNum) {
        this.postNum = postNum;
    }

    public void setUserNum(String userId) {
        this.userId = userId;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
