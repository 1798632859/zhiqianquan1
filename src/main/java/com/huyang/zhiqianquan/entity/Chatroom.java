package com.huyang.zhiqianquan.entity;


import java.io.Serializable;

public class Chatroom implements Serializable {

  private String chatroomId;
  private String userId;
  private long chatroomLikenum;
  private long chatroomReview;
  private String chatroomType;
  private String chatroomComment;
  private String chatroomStatus;
  private java.sql.Timestamp chatroomData;
  private String chatroomImage;

    private String userName;
    private String userImage;
    private String userSchool;
    private String userCompany;
    private String userPost;
    private User user;

    private String groupName;

    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getChatroomId() {
    return chatroomId;
  }

  public void setChatroomId(String chatroomId) {
    this.chatroomId = chatroomId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public long getChatroomLikenum() {
    return chatroomLikenum;
  }

  public void setChatroomLikenum(long chatroomLikenum) {
    this.chatroomLikenum = chatroomLikenum;
  }


  public long getChatroomReview() {
    return chatroomReview;
  }

  public void setChatroomReview(long chatroomReview) {
    this.chatroomReview = chatroomReview;
  }


  public String getChatroomType() {
    return chatroomType;
  }

  public void setChatroomType(String chatroomType) {
    this.chatroomType = chatroomType;
  }


  public String getChatroomComment() {
    return chatroomComment;
  }

  public void setChatroomComment(String chatroomComment) {
    this.chatroomComment = chatroomComment;
  }


  public String getChatroomStatus() {
    return chatroomStatus;
  }

  public void setChatroomStatus(String chatroomStatus) {
    this.chatroomStatus = chatroomStatus;
  }


  public java.sql.Timestamp getChatroomData() {
    return chatroomData;
  }

  public void setChatroomData(java.sql.Timestamp chatroomData) {
    this.chatroomData = chatroomData;
  }


  public String getChatroomImage() {
    return chatroomImage;
  }

  public void setChatroomImage(String chatroomImage) {
    this.chatroomImage = chatroomImage;
  }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
