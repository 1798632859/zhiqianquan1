package com.huyang.zhiqianquan.entity;


import java.io.Serializable;

public class Group implements Serializable {

  private String groupId;
  private String groupImage;
  private String groupCooment;
  private String groupName;
  private String groupStatus;


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public String getGroupImage() {
    return groupImage;
  }

  public void setGroupImage(String groupImage) {
    this.groupImage = groupImage;
  }


  public String getGroupCooment() {
    return groupCooment;
  }

  public void setGroupCooment(String groupCooment) {
    this.groupCooment = groupCooment;
  }


  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }


  public String getGroupStatus() {
    return groupStatus;
  }

  public void setGroupStatus(String groupStatus) {
    this.groupStatus = groupStatus;
  }

}
