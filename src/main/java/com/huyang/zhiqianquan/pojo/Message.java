package com.huyang.zhiqianquan.pojo;


public class Message {

  private String messageId;
  private String userId;
  private long messageGood;
  private String messageType;
  private String messageCommed;
  private String messageStatus;
  private java.sql.Timestamp messageData;
  private String messageImage;


  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public long getMessageGood() {
    return messageGood;
  }

  public void setMessageGood(long messageGood) {
    this.messageGood = messageGood;
  }


  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }


  public String getMessageCommed() {
    return messageCommed;
  }

  public void setMessageCommed(String messageCommed) {
    this.messageCommed = messageCommed;
  }


  public String getMessageStatus() {
    return messageStatus;
  }

  public void setMessageStatus(String messageStatus) {
    this.messageStatus = messageStatus;
  }


  public java.sql.Timestamp getMessageData() {
    return messageData;
  }

  public void setMessageData(java.sql.Timestamp messageData) {
    this.messageData = messageData;
  }


  public String getMessageImage() {
    return messageImage;
  }

  public void setMessageImage(String messageImage) {
    this.messageImage = messageImage;
  }

}
