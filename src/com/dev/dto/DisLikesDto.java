package com.dev.dto;

public class DisLikesDto {

    private Long disLikesNum;
    private Long userNum;
    private Long postNum;

    public DisLikesDto(Long disLikesNum, Long userNum, Long postNum) {
        this.disLikesNum = disLikesNum;
        this.userNum = userNum;
        this.postNum = postNum;
    }

    public Long getDisLikesNum() {
        return disLikesNum;
    }

    public Long getUserNum() {
        return userNum;
    }

    public Long getPostNum() {
        return postNum;
    }

    public void setDisLikesNum(Long disLikesNum) {
        this.disLikesNum = disLikesNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public void setPostNum(Long postNum) {
        this.postNum = postNum;
    }
}
