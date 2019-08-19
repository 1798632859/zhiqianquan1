package com.huyang.zhiqianquan.service.userserviceimpl;

import com.huyang.zhiqianquan.mapper.UserMapper;
import com.huyang.zhiqianquan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List queryalluser() {
        return userMapper.queryalluser();
    }
}