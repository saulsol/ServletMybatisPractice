package com.dev.dto;

public class CreatePostDto {

    private String postTitle;
    private String postContent;
    private String userId;

    public CreatePostDto() {
    }

    public CreatePostDto(String postTitle, String postContent, String userId) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
