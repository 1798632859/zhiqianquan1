package com.huyang.zhiqianquan.dao;

import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkMapper {
    /**
     * 添加招聘信息
     *
     * @param work
     */
    int addwork(Work work);

    /**
     * 查询所有招聘信息，带分页，每页8条
     *
     * @return
     */
    List<Work> querywork();

    /**
     * 多条件查询
     */
    List<Work> queryworktype(Work work);

    /**
     * 收藏
     */
    void addcollection(Collection collection);

    /**
     * 根据用户id查询收藏详情
     */
    List<Collection> querycollectionById(@Param("userId") String userId);

    /**
     * 根据workId查询work详情，或者根据用户ID查询用户已发布的招聘信息
     * @param
     * @return
     */
    List<Work> workById(@Param("workid") String workid, @Param("userid") String userid);

    /**
     * 根据workid修改work
     * @param work
     */
    void modifywork(Work work);
    /**
     * 删除已发布的招聘信息
     */
    void deletework(@Param("workid") String workid);
    /**
     * 删除收藏的招聘的信息
     */
    void deletecollectionwork(@Param("workid") String workid);
    /**
     * 查询所有领域
     */
    List<Work> worktypequery();
    /**
     * 查询所有领工作类别
     */
    List<Work> workposttypequery();
    /**
     * 查询所有城市
     */
    List<Work> workcityquery();
}
