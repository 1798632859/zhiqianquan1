package com.huyang.zhiqianquan.entity;


import java.io.Serializable;
import java.util.List;

public class Discuss implements Serializable {

  private String discussId;
  private String userId;
  private String touserId;
  private String chatroomId;
  private String discussFather;
  private String discussSon;
  private String discussComment;
  private java.sql.Timestamp discussData;
  private String discussStatus;
  private List<Discuss> list;





    public String getDiscussComment() {
        return discussComment;
    }

    public void setDiscussComment(String discussComment) {
        this.discussComment = discussComment;
    }

  public String getDiscussId() {
    return discussId;
  }

  public void setDiscussId(String discussId) {
    this.discussId = discussId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getChatroomId() {
    return chatroomId;
  }

  public void setChatroomId(String chatroomId) {
    this.chatroomId = chatroomId;
  }


  public String getDiscussFather() {
    return discussFather;
  }

  public void setDiscussFather(String discussFather) {
    this.discussFather = discussFather;
  }


  public String getDiscussSon() {
    return discussSon;
  }

  public void setDiscussSon(String discussSon) {
    this.discussSon = discussSon;
  }


  public java.sql.Timestamp getDiscussData() {
    return discussData;
  }

  public void setDiscussData(java.sql.Timestamp discussData) {
    this.discussData = discussData;
  }


  public String getDiscussStatus() {
    return discussStatus;
  }

  public void setDiscussStatus(String discussStatus) {
    this.discussStatus = discussStatus;
  }

    public List<Discuss> getList() {
        return list;
    }

    public void setList(List<Discuss> list) {
        this.list = list;
    }

    public String getTouserId() {
        return touserId;
    }

    public void setTouserId(String touserId) {
        this.touserId = touserId;
    }


}
