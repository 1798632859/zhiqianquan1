package com.huyang.zhiqianquan.entity;


import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {

  private String groupId;
  private String groupImage;
  private String groupCooment;
  private String groupName;
  private String groupStatus;
  private List<Chatroom> chatroom;

    public List<Chatroom> getChatroom() {
        return chatroom;
    }

    public void setChatroom(List<Chatroom> chatroom) {
        this.chatroom = chatroom;
    }

    public List<Chatroom> getChatroomList() {
        return chatroomList;
    }

    public void setChatroomList(List<Chatroom> chatroomList) {
        this.chatroomList = chatroomList;
    }

    private String founderUser;
  private List<Chatroom> chatroomList;

    public String getFounderUser() {
        return founderUser;
    }

    public void setFounderUser(String founderUser) {
        this.founderUser = founderUser;
    }

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
