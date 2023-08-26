package com.dev.dto;

public class SearchPostDto {

    private String postTitle;
    private String postContent;
    private int limit;
    private int offset;

    public SearchPostDto() {
    }

    public SearchPostDto(String postTitle, String postContent, int limit, int offset) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.limit = limit;
        this.offset = offset;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
