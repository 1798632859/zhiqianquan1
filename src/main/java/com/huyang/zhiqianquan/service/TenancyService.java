package com.huyang.zhiqianquan.service;

import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Tenancy;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TenancyService {
    /*
     *  查询所有求组消息(带分页)
     *
     */
    List<Tenancy> findqiuzuall();
    /**
     * 多条件查询求组消息(带分页)
     *
     */
    List<Tenancy> findqiuzumore(String tenancyType, String tenancyRegion, String tenancyPrice);
    /**
     * 发布求租消息
     *
     */
    void addtenancy(Tenancy tenancy);
    /**
     * 模糊查询求租信息
     *
     */
    List<Tenancy> likefind(String pattern);
    /**
     * 根据id查询求租信息
     *
     */
    List<Tenancy> finduserall(String userId);
    /**
     * 修改求租信息
     *
     */
    void updatetenancy(Tenancy tenancy);
    /**
     * 删除求租信息
     *
     */
    void deletetenancy(String tenancyId, String userId);
    /**
     * 点赞求租信息
     *
     */
    int Fabuloustenancy(String tenancyId);
    /**
     * 收藏求租信息
     *
     */
    void inserttenancy(Collection collection);
    /**
     * 查询是否收藏当前求租信息
     *
     */
    Collection selectcollextion(String tenancyId, String userId);
    //举报房源
    public int ReportHouse(HashMap<String, Object> reportMap);

}
