package com.entity;

import java.util.Arrays;
import java.util.Date;

public class User {
    private String username;
    private String mypassword;
    private String email;

    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 爱好
     */
    private String[] favorite;
    /**
     * 自我介绍
     */
    private String introduce;
    /**
     * 是否接受协议
     */
    private boolean isAcc;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMypassword() {
        return mypassword;
    }

    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String[] getFavorite() {
        return favorite;
    }

    public void setFavorite(String[] favorite) {
        this.favorite = favorite;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public boolean  getIsAcc(){
        return isAcc;
    }

    public void setAcc(boolean acc) {
        isAcc = acc;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", mypassword='" + mypassword + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", favorite=" + Arrays.toString(favorite) +
                ", introduce='" + introduce + '\'' +
                ", isAcc=" + isAcc +
                '}';
    }

}
