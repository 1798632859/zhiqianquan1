package com.huyang.zhiqianquan.pojo;


public class Shoucang {

  private String shoucangId;
  private String userId;
  private String messageId;
  private java.sql.Timestamp shoucangData;
  private String shoucangStatus;


  public String getShoucangId() {
    return shoucangId;
  }

  public void setShoucangId(String shoucangId) {
    this.shoucangId = shoucangId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }


  public java.sql.Timestamp getShoucangData() {
    return shoucangData;
  }

  public void setShoucangData(java.sql.Timestamp shoucangData) {
    this.shoucangData = shoucangData;
  }


  public String getShoucangStatus() {
    return shoucangStatus;
  }

  public void setShoucangStatus(String shoucangStatus) {
    this.shoucangStatus = shoucangStatus;
  }

}
