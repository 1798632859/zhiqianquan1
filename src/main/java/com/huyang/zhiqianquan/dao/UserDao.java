package com.huyang.zhiqianquan.dao;

import com.huyang.zhiqianquan.entity.User;
import com.huyang.zhiqianquan.entity.Work;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface UserDao {
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
