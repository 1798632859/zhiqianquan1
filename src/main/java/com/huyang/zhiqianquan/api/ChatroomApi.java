package com.huyang.zhiqianquan.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyang.zhiqianquan.entity.Chatroom;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Discuss;
import com.huyang.zhiqianquan.service.ChatroomService;
import com.huyang.zhiqianquan.util.IdUtil;
import com.huyang.zhiqianquan.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin
@RestController
public class ChatroomApi {
    @Autowired
    ChatroomService ChatroomServiceimpl;

    /**
     * 查询所有消息带分页
     * @return
     */
    @RequestMapping(value = "/api/message/selectchatroomall")
    public JsonResult selectmessageall(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize
    ) {
        JsonResult result = null;
        try {
            System.out.println(pageNum);
            System.out.println(pageSize);
            PageHelper.startPage(pageNum, pageSize);
            List<Chatroom> list = ChatroomServiceimpl.selectchatroomall();
            if (list != null) {
                PageInfo pageInfo = new PageInfo(list);
                result = new JsonResult("200", "查询成功", pageInfo);
                return result;
            } else {
                result = new JsonResult("404", "查询失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;

        }
    }

    /**
     * 添加消息
     */

    @RequestMapping("/api/message/addchatroom")
    public JsonResult addmessage(
            String userId,
            @RequestParam(value = "messageType", required = true, defaultValue = "0") String chatroomType,
            String chatroomComment,
            String chatroomImage
    ) {
        JsonResult result = null;
        Chatroom chatroom =new Chatroom();
        chatroom.setChatroomId(IdUtil.getUuid());
        chatroom.setUserId(userId);
        chatroom.setChatroomLikenum(0);
        chatroom.setChatroomReview(0);
        chatroom.setChatroomType(chatroomType);
        chatroom.setChatroomComment(chatroomComment);
        chatroom.setChatroomImage(chatroomImage);
        chatroom.setChatroomStatus("1");
        Timestamp data = new Timestamp(System.currentTimeMillis());
        chatroom.setChatroomData(data);
        try {
            int i = ChatroomServiceimpl.addchatroom(chatroom);
            if (i != 0) {
                result = new JsonResult("200", "添加成功", i);
                return result;
            } else {
                result = new JsonResult("404", "添加失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;

        }
    }

    /**
     * 删除消息
     */
    @RequestMapping("/api/message/delchatroombyId")
    public JsonResult selectmessageall(
            String chatroomId
    ) {
        JsonResult result = null;
        try {
            int i = ChatroomServiceimpl.delchatroombyId(chatroomId);
            if (i != 0) {
                result = new JsonResult("200", "查询成功", i);
                return result;
            } else {
                result = new JsonResult("404", "查询失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;

        }
    }

    /**
     * 根据消息ID查询消息详情
     */
    @RequestMapping("/api/message/selectchatroombyId")
    public JsonResult selectmessagebyId(
            String chatroomId
    ) {
        JsonResult result = null;
        System.out.println(chatroomId);
        try {
            Chatroom list= ChatroomServiceimpl.selectchatroombyId(chatroomId);
            if (list != null) {
                result = new JsonResult("200", "查询成功", list);
                return result;
            } else {
                result = new JsonResult("404", "查询失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;

        }
    }

    /**
     * 根据消息ID查询当前点赞数
     */
    @RequestMapping("/api/message/selectchatlikenumbyId")
    public JsonResult selectchatlikenumbyId(
            String chatroomId
    ) {
        JsonResult result = null;
        try {
            long i = ChatroomServiceimpl.selectchatlikenumbyId(chatroomId);
            result = new JsonResult("200", "查询成功", i);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;

        }
    }

    /**
     * 点赞功能
     */
    @RequestMapping("/api/message/updatechatroomlikenums")
    public JsonResult updatechatlikenumbyId(
            String chatroomId
    ) {
        JsonResult result = null;
        try {
            int i = ChatroomServiceimpl.updatechatroomlikenums(chatroomId);
            result = new JsonResult("200", "点赞成功", i);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;
        }
    }
    /**
     * 取消赞赞功能
     */
    @RequestMapping("/api/message/updatedownlikenum")
    public JsonResult updatedownlikenum(
            String chatroomId
    ) {
        JsonResult result = null;
        try {
            int i = ChatroomServiceimpl.updatedownlikenum(chatroomId);
            result = new JsonResult("200", "取消赞成功", i);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;
        }
    }

    /**
     * 查询用户所发的所有消息带分页
     * @return
     */
    @RequestMapping("/api/message/selectchatroomallbyId")
    public JsonResult selectchatroomallbyId(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize,
            String userId
    ) {
        JsonResult result = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Chatroom> list = ChatroomServiceimpl.selectchatroomallbyId(userId);
            if (list != null) {
                PageInfo pageInfo = new PageInfo(list);
                result = new JsonResult("200", "查询成功", pageInfo);
                return result;
            } else {
                result = new JsonResult("404", "查询失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;

        }
    }

    /**
     * 收藏此消息
     */
    @RequestMapping("/api/message/addcollectionbychatroomId")
    public JsonResult addcollectionbychatroomId(
            String userId,
            String chatroomId
    ) {
        JsonResult result = null;
        Collection collection =new Collection();
        collection.setCollectionId(IdUtil.getUuid());
        collection.setChatroomId(chatroomId);
        collection.setUserId(userId);
        Timestamp data = new Timestamp(System.currentTimeMillis());
        collection.setCollectionData(data);
        collection.setCollectionStatus("1");
        try {
            int i = ChatroomServiceimpl.addcollectionbychatroomId(collection);
            if (i != 0) {
                result = new JsonResult("200", "收藏成功", i);
                return result;
            } else {
                result = new JsonResult("404", "收藏失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;
        }
    }

    /**
     * 查询某消息 评论
     */
    @RequestMapping("/api/message/selectdiscussbyId")
    public JsonResult selectdiscussbyId(
            String chatroomId
    ) {
        JsonResult result = null;
        try {
            System.out.println(chatroomId);
            List<Discuss> list = ChatroomServiceimpl.selectalldiscussbyId(chatroomId);
            if (list != null) {
                result = new JsonResult("200", "查询成功", list);
                return result;
            } else {
                result = new JsonResult("404", "查询评论失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;
        }
    }

    /**
     * 发送一级评论
     */
    @RequestMapping("/api/message/adddoneiscuss")
    public JsonResult adddoneiscuss(
                String userId,
                String touserId,
                String chatroomId,
                String chartroomComment
    ) {
        JsonResult result = null;
        Discuss discuss=new Discuss();
        discuss.setDiscussId(IdUtil.getUuid());
        discuss.setUserId(userId);
        discuss.setTouserId(touserId);
        discuss.setChatroomId(chatroomId);
        discuss.setDiscussComment(chartroomComment);
        Timestamp data = new Timestamp(System.currentTimeMillis());
        discuss.setDiscussData(data);
        discuss.setDiscussStatus("1");

        try {
            int i = ChatroomServiceimpl.adddoneiscuss(discuss);
            if (i != 0) {
                result = new JsonResult("200", "查询成功", i);
                return result;
            } else {
                result = new JsonResult("404", "查询评论失败", "");
                return result;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
            return result;
        }
    }
}
