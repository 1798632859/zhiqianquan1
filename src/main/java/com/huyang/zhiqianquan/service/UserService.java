package com.huyang.zhiqianquan.service;

import com.huyang.zhiqianquan.entity.User;
import com.huyang.zhiqianquan.entity.Work;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List queryalluser();
    List queryhousebyuserid(String userId);
    List queryworkbyuserid(String userId);
    User queryuserbyuserid(String userId);
    List querytenancybyuserid(String userId);
    List querychatroombyuserid(String userId);
    int updateuserbyid(HashMap map);
    List<Work> querycollectionworkbyuserid(String userId);
    List querycollectiontenancybyuserid(String userId);
    List querycollectionhousebyuserid(String userId);
}
