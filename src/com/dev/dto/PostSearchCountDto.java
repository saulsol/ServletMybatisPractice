package com.dev.dto;

public class PostSearchCountDto {

    private String postTitle;
    private String postContent;

    public PostSearchCountDto() {

    }

    public PostSearchCountDto(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }


    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
