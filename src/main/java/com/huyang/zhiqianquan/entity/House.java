package com.huyang.zhiqianquan.entity;


import java.io.Serializable;
import java.util.List;

public class House implements Serializable {

  private String houseId;
  private String userId;
  private String housePeople;
  private String houseType;
  private String houseAtcity;
  private String houseRegion;
  private String housePost;
  private Integer housePrice;
  private String houseVx;
  private String houseTelephone;
  private String houseLabel1;
  private String houseLabel2;
  private String houseLabel3;
  private String houseTitle;
  private String houseDescribe;
  private java.sql.Timestamp houseTime;
  private String houseStatus;

  private User user;
  private List<Chart> chart;


  public String getHouseVx() {
        return houseVx;
    }

    public void setHouseVx(String houseVx) {
        this.houseVx = houseVx;
    }

    public String getHouseTelephone() {
        return houseTelephone;
    }

    public void setHouseTelephone(String houseTelephone) {
        this.houseTelephone = houseTelephone;
    }

    public String getHousePeople() {
        return housePeople;
    }

    public void setHousePeople(String housePeople) {
        this.housePeople = housePeople;
    }

    public List<Chart> getChart() {
    return chart;
  }

  public void setChart(List<Chart> chart) {
    this.chart = chart;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

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

  public void setHousePrice(Integer housePrice) {
    this.housePrice = housePrice;
  }


    public String getHouseLabel1() {
        return houseLabel1;
    }

    public void setHouseLabel1(String houseLabel1) {
        this.houseLabel1 = houseLabel1;
    }

    public String getHouseLabel2() {
        return houseLabel2;
    }

    public void setHouseLabel2(String houseLabel2) {
        this.houseLabel2 = houseLabel2;
    }

    public String getHouseLabel3() {
        return houseLabel3;
    }

    public void setHouseLabel3(String houseLabel3) {
        this.houseLabel3 = houseLabel3;
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
