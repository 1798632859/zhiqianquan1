package com.huyang.zhiqianquan.pojo;


public class Pinglun {

  private String pinglunId;
  private String userId;
  private String messageId;
  private String pinglunFather;
  private String pinglunSon;
  private java.sql.Timestamp pinglunData;
  private String pinglunStatus;


  public String getPinglunId() {
    return pinglunId;
  }

  public void setPinglunId(String pinglunId) {
    this.pinglunId = pinglunId;
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


  public String getPinglunFather() {
    return pinglunFather;
  }

  public void setPinglunFather(String pinglunFather) {
    this.pinglunFather = pinglunFather;
  }


  public String getPinglunSon() {
    return pinglunSon;
  }

  public void setPinglunSon(String pinglunSon) {
    this.pinglunSon = pinglunSon;
  }


  public java.sql.Timestamp getPinglunData() {
    return pinglunData;
  }

  public void setPinglunData(java.sql.Timestamp pinglunData) {
    this.pinglunData = pinglunData;
  }


  public String getPinglunStatus() {
    return pinglunStatus;
  }

  public void setPinglunStatus(String pinglunStatus) {
    this.pinglunStatus = pinglunStatus;
  }

}
