package com.huyang.zhiqianquan.service.impl;

import com.huyang.zhiqianquan.dao.UserDao;
import com.huyang.zhiqianquan.entity.Admin;
import com.huyang.zhiqianquan.entity.User;
import com.huyang.zhiqianquan.entity.Work;
import com.huyang.zhiqianquan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List queryalluser() {
        return userDao.queryalluser();
    }

    @Override
    public List queryhousebyuserid(String userId) {
        return userDao.queryhousebyuserid(userId);
    }

    @Override
    public List queryworkbyuserid(String userId) {
        return userDao.queryworkbyuserid(userId);
    }

    @Override
    public User queryuserbyuserid(String userId) {
        return userDao.queryuserbyuserid(userId);
    }

    @Override
    public List querytenancybyuserid(String userId) {
        return userDao.querytenancybyuserid(userId);
    }

    @Override
    public List querychatroombyuserid(String userId) {
        return userDao.querychatroombyuserid(userId);
    }

    @Override
    public int updateuserbyid(HashMap map) {

        return userDao.updateuserbyid(map);
    }

    @Override
    public List<Work> querycollectionworkbyuserid(String userId) {
        return userDao.querycollectionworkbyuserid(userId);
    }

    @Override
    public List querycollectiontenancybyuserid(String userId) {
        return userDao.querycollectiontenancybyuserid(userId);
    }

    @Override
    public List querycollectionhousebyuserid(String userId) {
        return userDao.querycollectionhousebyuserid(userId);
    }

    @Override
    public Admin loginadmin(HashMap map) {
        return userDao.loginadmin(map);
    }

    @Override
    public Integer registeradmin(Admin admin) {
        return userDao.registeradmin(admin);
    }

    @Override
    public Integer updateadminbyid(HashMap map) {
        return userDao.updateadminbyid(map);
    }

}
