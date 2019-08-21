package com.huyang.zhiqianquan.service.impl;

import com.huyang.zhiqianquan.dao.TenancyDao;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Tenancy;
import com.huyang.zhiqianquan.service.TenancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TenancyServiceImpl implements TenancyService {
    @Autowired
    TenancyDao tenancyDao;
    /**
     * 查询所有求组消息(带分页)
     * @return
     */
    @Override
    public List<Tenancy> findqiuzuall() {
        return tenancyDao.findqiuzuall();
    }
    /**
     * 多条件查询求组消息(带分页)
     *
     */
    @Override
    public List<Tenancy> findqiuzumore(String tenancyType, String tenancyRegion, String tenancyPrice) {
        return tenancyDao.findqiuzumore(tenancyType,tenancyRegion,tenancyPrice);
    }
    /**
     * 发布求租消息
     *
     */
    @Override
    public void addtenancy(Tenancy tenancy) {
        tenancyDao.addtenancy(tenancy);
    }
    /**
     * 模糊查询求租信息
     *
     */
    @Override
    public List<Tenancy> likefind(String pattern) {
        return tenancyDao.likefind(pattern);
    }
    /**
     * 根据id查询求租信息
     *
     */
    @Override
    public List<Tenancy> finduserall(String userId) {
        return tenancyDao.finduserall(userId);
    }
    /**
     * 修改求租信息
     *
     */
    @Override
    public void updatetenancy(Tenancy tenancy) {
        tenancyDao.updatetenancy(tenancy);
    }

    /**
     * 删除求租信息
     *
     */
    @Override
    public void deletetenancy(String tenancyId,String userId) {
        tenancyDao.deletetenancy(tenancyId,userId);
    }

    @Override
    public int Fabuloustenancy(String tenancyId) {
        int i=tenancyDao.Fabuloustenancy(tenancyId);
            i+=1;
        String Fabulous=String.valueOf(i);
        return  tenancyDao.Fabuloustenancyadd(Fabulous,tenancyId);
    }
    /**
     * 收藏求租信息
     *
     */
    @Override
    public void inserttenancy(Collection collection) {
       String  tenancyId=collection.getTenancyId();
       String  userId=collection.getUserId();
       Collection collections=tenancyDao.selectcollextion(tenancyId,userId);
       if (collections!=null){
           if("0".equals(collections.getCollectionStatus())){
               tenancyDao.addcollextion(tenancyId,userId);
           }else{
               tenancyDao.deletecollextion(tenancyId,userId);
           }
       }else {
           tenancyDao.inserttenancy(collection);
       }
    }
    /**
     * 查询是否收藏当前求租信息
     *
     */
    @Override
    public Collection selectcollextion(String tenancyId, String userId) {
        return tenancyDao.selectcollextion(tenancyId,userId);
    }
    //举报房源
    @Override
    public int ReportHouse(HashMap<String, Object> reportMap) {
        return tenancyDao.ReportHouse(reportMap);
    }
}
