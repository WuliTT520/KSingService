package com.ksing.demo.entity;

import java.util.List;

public class UserInfo {
    private String user_dp,user_name;
    private String is_Vip;
    private int friend_num,focused_num,grade;

    public String getUser_dp() {
        return user_dp;
    }

    public void setUser_dp(String user_dp) {
        this.user_dp = user_dp;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getIs_Vip() {
        return is_Vip;
    }

    public void setIs_Vip(String is_Vip) {
        this.is_Vip = is_Vip;
    }

    public int getFriend_num() {
        return friend_num;
    }

    public void setFriend_num(int friend_num) {
        this.friend_num = friend_num;
    }

    public int getFocused_num() {
        return focused_num;
    }

    public void setFocused_num(int focused_num) {
        this.focused_num = focused_num;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void print(){
        System.out.println(user_dp+" "+user_name+" "+is_Vip+" "+friend_num+" "+focused_num+" "+grade);
    }
}
