package com.huyang.zhiqianquan.service.impl;

import com.huyang.zhiqianquan.dao.ChatroomDao;
import com.huyang.zhiqianquan.entity.Chatroom;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Discuss;
import com.huyang.zhiqianquan.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChatroomServiceimpl implements ChatroomService {
    @Autowired
    ChatroomDao chatroomDao;

    @Override
    public List<Chatroom> selectchatroomall() {
        return chatroomDao.selectchatroomall();
    }

    @Override
    public int addchatroom(Chatroom chatroom) {
        return chatroomDao.addchatroom(chatroom);
    }

    @Override
    public int delchatroombyId(String chatroomId) {
        return chatroomDao.delchatroombyId(chatroomId);
    }

    @Override
    public Chatroom selectchatroombyId(String chatroomId) {
        return chatroomDao.selectchatroombyId(chatroomId);
    }

    @Override
    public long selectchatlikenumbyId(String chatroomId) {
        return chatroomDao.selectchatlikenumbyId(chatroomId);
    }

    /**
     * 取消赞
     * @param chatroomId
     * @return
     */
    @Override
    public int updatedownlikenum(String chatroomId) {
        return chatroomDao.updatedownlikenum(chatroomId);
    }

    /**
     * 点赞功能
     * @param chatroomId
     * @return
     */
    @Override
    public int updatechatroomlikenums(String chatroomId) {
        return chatroomDao.updatechatroomlikenums(chatroomId);
    }


    /**
     * 根据用户ID查询用户所发所有消息
     */
    @Override
    public List<Chatroom> selectchatroomallbyId(String userId) {
        return chatroomDao.selectchatroomallbyId(userId);
    }

    /**
     *
     * 收藏消息
     * @return
     */
    @Override
    public int addcollectionbychatroomId(Collection collection) {
        return chatroomDao.addcollectionbychatroomId(collection);
    }

    /**
     * 查询所有评论
     * @param chatroomId
     * @return
     */
    @Override
    public List<Discuss> selectalldiscussbyId(String chatroomId) {
        List<Discuss> father =chatroomDao.selectdiscussbyId(chatroomId);
        List<Discuss> son =chatroomDao.selectsondiscussbyId(chatroomId);
        for(Discuss f : father){
            List list=new ArrayList();
            f.setList(list);
            for(Discuss s : son){
                if(s.getDiscussFather().equals(f.getDiscussId())){
                    f.getList().add(s);
                }
            }

        }

        return father;
    }


    /**
     * 发送一级评论
     */
    @Override
    public int adddoneiscuss(Discuss discuss) {
        return chatroomDao.adddoneiscuss(discuss);
    }

    /**
     * 发送二级评论
     */
    @Override
    public int adddtwoiscuss(Discuss discuss) {
        return chatroomDao.adddtwoiscuss(discuss);
    }

    /**
     * 查询评论条数
     * @param chatroomId
     * @return
     */
    @Override
    public long selectalldiscussnum(String chatroomId) {
        return chatroomDao.selectalldiscussnum(chatroomId);
    }


}
