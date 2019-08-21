package com.huyang.zhiqianquan.dao;

import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Tenancy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component

public interface TenancyDao {
    /*
     *  查询所有求组消息(带分页)
     *
     */
    List<Tenancy> findqiuzuall();
    /**
     * 多条件查询求组消息(带分页)
     *
     */
    List<Tenancy> findqiuzumore(@Param("tenancyType") String tenancyType, @Param("tenancyRegion") String tenancyRegion, @Param("tenancyPrice") String tenancyPrice);
    /**
     * 发布求租消息
     */
    void addtenancy(Tenancy tenancy);
    /**
     * 模糊查询求租信息
     *
     */
    List<Tenancy> likefind(@Param("pattern") String pattern);
    /**
     * 根据id查询求租信息
     *
     */
    List<Tenancy> finduserall(@Param("userId") String userId);
    /**
     * 修改求租信息
     *
     */
    void  updatetenancy(Tenancy tenancy);
    /**
     * 删除求租信息
     *
     */
    void deletetenancy(@Param("tenancyId") String tenancyId, @Param("userId") String userId);
    /**
     * 点赞求租信息
     *
     */
    int Fabuloustenancy(@Param("tenancyId") String tenancyId);
    int Fabuloustenancyadd(@Param("Fabulous") String Fabulous, @Param("tenancyId") String tenancyId);
    /**
     * 收藏求租信息
     *
     */
    void inserttenancy(Collection collection);
    void addcollextion(@Param("tenancyId") String tenancyId, @Param("userId") String userId);
    void deletecollextion(@Param("tenancyId") String tenancyId, @Param("userId") String userId);
    /**
     * 查询是否收藏当前求租信息
     *
     */
    Collection selectcollextion(@Param("tenancyId") String tenancyId, @Param("userId") String userId);


    //举报房源
    public int ReportHouse(HashMap<String, Object> reportMap);
}
