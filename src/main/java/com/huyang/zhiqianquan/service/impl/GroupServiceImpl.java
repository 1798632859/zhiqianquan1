package com.huyang.zhiqianquan.service.impl;

import com.huyang.zhiqianquan.dao.GroupDao;
import com.huyang.zhiqianquan.entity.Group;
import com.huyang.zhiqianquan.entity.User;
import com.huyang.zhiqianquan.entity.UserGroup;
import com.huyang.zhiqianquan.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupDao dao;
    /**
     * 创建社区
     * @param group
     * @return
     */
    @Override
    public void addgroup(HashMap hashMap) {
       dao.addgroup((Group)hashMap.get("group"));
       dao.addusergroup((UserGroup) hashMap.get("userGroup"));
    }
    /**
     * 更改社区
     * @param group
     */
    @Override
    public void updategroup(Group group) {
        dao.updategroup(group);
    }
    /**
     * 查询社区，带模糊搜索，带Id搜索，或者查询所有社区
     */
    @Override
    public List<Group> querygroup(Group group) {
        return dao.querygroup(group);
    }
    /**
     * 删除社区
     */
     public void deletegroup(String groupId){
         dao.deletegroup(groupId);
     }
    /**
     * 查询用户所拥有的群
     */
    @Override
    public List<Group> queryuserallgroup(String userId) {
        return dao.queryuserallgroup(userId);
    }
}
