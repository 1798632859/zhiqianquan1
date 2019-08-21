package com.huyang.zhiqianquan.service;

import com.huyang.zhiqianquan.entity.Chatroom;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Discuss;

import java.util.List;

public interface ChatroomService {
    /**
     * 查询所有消息带分页
     */

    List<Chatroom> selectchatroomall();

    /**
     * 添加消息
     */
    int addchatroom(Chatroom chatroom);

    /**
     * 删除消息
     */

    int delchatroombyId(String chatroomId);

    /**
     * 根据消息ID查询消息详情
     */
    Chatroom selectchatroombyId(String chatroomId);

    /**
     * 根据消息ID查询消息点赞数
     * @param chatroomId
     * @return
     */
    long selectchatlikenumbyId(String chatroomId);

    /**
     * 取消赞
     */
    int updatedownlikenum(String chatroomId);

    /**
     * 点赞功能
     */
    int updatechatroomlikenums(String chatroomId);

    /**
     * 根据用户ID查询用户所发所有消息
     */
    List<Chatroom> selectchatroomallbyId(String userId);

    /**
     * 收藏消息
     */
    int addcollectionbychatroomId(Collection collection);

    /**
     * 查询所有评论
     */
    List<Discuss> selectalldiscussbyId(String chatroomId);

    /**
     * 发送一级评论
     */
    int adddoneiscuss(Discuss discuss);

}
