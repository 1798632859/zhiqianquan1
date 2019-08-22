package com.huyang.zhiqianquan.service;

import com.huyang.zhiqianquan.entity.Group;

import java.util.HashMap;
import java.util.List;

public interface GroupService {
    /**
     * 创建社区
     * @param
     * @return
     */
    void addgroup(HashMap hashMap);

    /**
     * 更改社区
     * @param group
     */
    void updategroup(Group group);
    /**
     * 查询社区，带模糊搜索，带Id搜索，或者查询所有社区
     */
    List<Group> querygroup(Group group);
    /**
     * 删除社区
     */
    void deletegroup(String groupId);
    /**
     * 查询用户所拥有的群
     */
    List<Group> queryuserallgroup(String userId);
    /**
     * 根据社区查社区帖子
     * @param groupId
     * @return
     */
    Group querygroupchartroom( String groupId);

}
