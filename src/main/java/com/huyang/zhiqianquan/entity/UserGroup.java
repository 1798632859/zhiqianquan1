package com.huyang.zhiqianquan.entity;


import java.io.Serializable;

public class UserGroup implements Serializable {

  private String userGroupId;
  private String userId;
  private String groupId;
  private String userGroupStatus;


  public String getUserGroupId() {
    return userGroupId;
  }

  public void setUserGroupId(String userGroupId) {
    this.userGroupId = userGroupId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public String getUserGroupStatus() {
    return userGroupStatus;
  }

  public void setUserGroupStatus(String userGroupStatus) {
    this.userGroupStatus = userGroupStatus;
  }

}
