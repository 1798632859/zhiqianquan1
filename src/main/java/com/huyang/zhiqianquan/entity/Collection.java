package com.huyang.zhiqianquan.entity;


import java.io.Serializable;

public class Collection implements Serializable {

  private String collectionId;
  private String userId;
  private String workId;
  private String houseId;
  private String tenancyId;
  private String chatroomId;
  private java.sql.Timestamp collectionData;
  private Work work;

  public Work getWork() {
    return work;
  }

  public void setWork(Work work) {
    this.work = work;
  }

  public String getWorkId() {
    return workId;
  }

  public void setWorkId(String workId) {
    this.workId = workId;
  }

  public String getHouseId() {
    return houseId;
  }

  public void setHouseId(String houseId) {
    this.houseId = houseId;
  }

  public String getTenancyId() {
    return tenancyId;
  }

  public void setTenancyId(String tenancyId) {
    this.tenancyId = tenancyId;
  }

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
