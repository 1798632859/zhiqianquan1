package com.huyang.zhiqianquan.dao;

import com.huyang.zhiqianquan.entity.Group;
import com.huyang.zhiqianquan.entity.UserGroup;
import com.huyang.zhiqianquan.entity.order;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao {
    /**
     * 创建社区
     * @param group
     * @return
     */
    void addgroup(Group group);

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
     * 成员加入群
     */
    void addusergroup(UserGroup userGroup);
    /**
     * 查询用户所拥有的群
     */
    List<Group> queryuserallgroup(@Param("userId") String userId);

    /**
     * 根据社区查社区帖子
     * @param groupId
     * @return
     */
    Group querygroupchartroom(@Param("groupId") String groupId);

    /**
     * 查询所有的群的人数，根据人数降序
     * @return
     */
    List<order> querynumberdesc();
}
