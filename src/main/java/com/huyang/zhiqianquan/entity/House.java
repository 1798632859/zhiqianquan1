package com.huyang.zhiqianquan.entity;


import java.io.Serializable;

public class House implements Serializable {

  private String houseId;
  private String userId;
  private String houseType;
  private String houseAtcity;
  private String houseRegion;
  private String housePost;
  private long housePrice;
  private String houseContact;
  private String houseLabel;
  private String houseTitle;
  private String houseDescribe;
  private String houseImages;
  private java.sql.Timestamp houseTime;
  private String houseStatus;


  public String getHouseId() {
    return houseId;
  }

  public void setHouseId(String houseId) {
    this.houseId = houseId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getHouseType() {
    return houseType;
  }

  public void setHouseType(String houseType) {
    this.houseType = houseType;
  }


  public String getHouseAtcity() {
    return houseAtcity;
  }

  public void setHouseAtcity(String houseAtcity) {
    this.houseAtcity = houseAtcity;
  }


  public String getHouseRegion() {
    return houseRegion;
  }

  public void setHouseRegion(String houseRegion) {
    this.houseRegion = houseRegion;
  }


  public String getHousePost() {
    return housePost;
  }

  public void setHousePost(String housePost) {
    this.housePost = housePost;
  }


  public long getHousePrice() {
    return housePrice;
  }

  public void setHousePrice(long housePrice) {
    this.housePrice = housePrice;
  }


  public String getHouseContact() {
    return houseContact;
  }

  public void setHouseContact(String houseContact) {
    this.houseContact = houseContact;
  }


  public String getHouseLabel() {
    return houseLabel;
  }

  public void setHouseLabel(String houseLabel) {
    this.houseLabel = houseLabel;
  }


  public String getHouseTitle() {
    return houseTitle;
  }

  public void setHouseTitle(String houseTitle) {
    this.houseTitle = houseTitle;
  }


  public String getHouseDescribe() {
    return houseDescribe;
  }

  public void setHouseDescribe(String houseDescribe) {
    this.houseDescribe = houseDescribe;
  }


  public String getHouseImages() {
    return houseImages;
  }

  public void setHouseImages(String houseImages) {
    this.houseImages = houseImages;
  }


  public java.sql.Timestamp getHouseTime() {
    return houseTime;
  }

  public void setHouseTime(java.sql.Timestamp houseTime) {
    this.houseTime = houseTime;
  }


  public String getHouseStatus() {
    return houseStatus;
  }

  public void setHouseStatus(String houseStatus) {
    this.houseStatus = houseStatus;
  }

}
