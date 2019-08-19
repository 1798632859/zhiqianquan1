package com.huyang.zhiqianquan.entity;


import java.io.Serializable;

public class User implements Serializable {

  private String userId;
  private String userName;
  private String userPassword;
  private String userVx;
  private String userEmail;
  private String userImage;
  private String userSchool;
  private String userSex;
  private String userCompany;
  private String userPost;
  private String userPostImage;
  private String userStatus;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getUserVx() {
    return userVx;
  }

  public void setUserVx(String userVx) {
    this.userVx = userVx;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserImage() {
    return userImage;
  }

  public void setUserImage(String userImage) {
    this.userImage = userImage;
  }


  public String getUserSchool() {
    return userSchool;
  }

  public void setUserSchool(String userSchool) {
    this.userSchool = userSchool;
  }


  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }


  public String getUserCompany() {
    return userCompany;
  }

  public void setUserCompany(String userCompany) {
    this.userCompany = userCompany;
  }


  public String getUserPost() {
    return userPost;
  }

  public void setUserPost(String userPost) {
    this.userPost = userPost;
  }


  public String getUserPostImage() {
    return userPostImage;
  }

  public void setUserPostImage(String userPostImage) {
    this.userPostImage = userPostImage;
  }


  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

}
