package com.huyang.zhiqianquan.entity;


import java.io.Serializable;

public class Collection implements Serializable {

  private String collectionId;
  private String userId;
  private String chatroomId;
  private java.sql.Timestamp collectionData;
  private String collectionStatus;


  public String getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(String collectionId) {
    this.collectionId = collectionId;
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


  public java.sql.Timestamp getCollectionData() {
    return collectionData;
  }

  public void setCollectionData(java.sql.Timestamp collectionData) {
    this.collectionData = collectionData;
  }


  public String getCollectionStatus() {
    return collectionStatus;
  }

  public void setCollectionStatus(String collectionStatus) {
    this.collectionStatus = collectionStatus;
  }

}
