package com.dev.dto;

public class PostDto {

    private Long postNum;
    private Long userNum;
    private String postTitle;
    private String postContent;

    public PostDto(){}

    public PostDto(Long postNum, Long userNum, String postTitle, String postContent) {
        this.postNum = postNum;
        this.userNum = userNum;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public Long getPostNum() {
        return postNum;
    }

    public Long getUserNum() {
        return userNum;
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

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
