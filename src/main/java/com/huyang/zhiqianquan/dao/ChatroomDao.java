package com.huyang.zhiqianquan.dao;

import com.huyang.zhiqianquan.entity.Chatroom;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Discuss;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ChatroomDao {
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
     * 点赞功能
     */
    int updatechatroomlikenums(String chatroomId);

    /**
     * 取消赞
     */
    int updatedownlikenum(String chatroomId);

    /**
     * 根据用户ID查询用户所发所有消息
     */
    List<Chatroom> selectchatroomallbyId(String userId);

    /**
     * 收藏消息
     */
    int addcollectionbychatroomId(Collection collection);

    /**
     * 查询一级评论
     */
    List<Discuss> selectdiscussbyId(String chatroomId);

    /**
     * 查询二级评论
     */
    List<Discuss> selectsondiscussbyId(String chatroomId);

    /**
     * 发送一级评论
     */
    int adddoneiscuss(Discuss discuss);
}
