package com.ksing.demo.entity;

import java.util.List;

public class DynamicStateInfo {
    String state_code;
    String code;
    String song_code;
    String user_text;
    String share_num;
    String like_num;
    String evaluate_num;
    String gift_num;
    String user_dp;
    String name;
    List<Comment> comments;

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSong_code() {
        return song_code;
    }

    public void setSong_code(String song_code) {
        this.song_code = song_code;
    }

    public String getUser_text() {
        return user_text;
    }

    public void setUser_text(String user_text) {
        this.user_text = user_text;
    }

    public String getShare_num() {
        return share_num;
    }

    public void setShare_num(String share_num) {
        this.share_num = share_num;
    }

    public String getLike_num() {
        return like_num;
    }

    public void setLike_num(String like_num) {
        this.like_num = like_num;
    }

    public String getEvaluate_num() {
        return evaluate_num;
    }

    public void setEvaluate_num(String evaluate_num) {
        this.evaluate_num = evaluate_num;
    }

    public String getGift_num() {
        return gift_num;
    }

    public void setGift_num(String gift_num) {
        this.gift_num = gift_num;
    }

    public String getUser_dp() {
        return user_dp;
    }

    public void setUser_dp(String user_dp) {
        this.user_dp = user_dp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
