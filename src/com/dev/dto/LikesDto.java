package com.dev.dto;

public class LikesDto {

    private Long likesNum;
    private Long userNum;
    private Long postMum;

    public LikesDto(){}

    public LikesDto(Long likesNum, Long userNum, Long postMum) {
        this.likesNum = likesNum;
        this.userNum = userNum;
        this.postMum = postMum;
    }

    public Long getLikesNum() {
        return likesNum;
    }

    public Long getUserNum() {
        return userNum;
    }

    public Long getPostMum() {
        return postMum;
    }

    public void setLikesNum(Long likesNum) {
        this.likesNum = likesNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public void setPostMum(Long postMum) {
        this.postMum = postMum;
    }
}
