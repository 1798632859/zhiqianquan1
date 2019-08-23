package com.huyang.zhiqianquan.service.impl;


import com.huyang.zhiqianquan.dao.WorkMapper;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Work;
import com.huyang.zhiqianquan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper mapper;
    /**
     * 添加招聘信息
     * @param work
     */
    @Override
    public int addwork(Work work) {
        return mapper.addwork(work);
    }
    /**
     * 查询所有招聘信息，带分页，每页8条
     * @return
     */
    @Override
    public List<Work> querywork() {
        return mapper.querywork();
    }
    /**
     * 按照类别查询信息
     */
    @Override
    public List<Work> queryworktype(Work work) {
        return mapper.queryworktype(work);
    }

    /**
     * 添加收藏
     * @param collection
     */
    @Override
    public void addcollection(Collection collection) {
        mapper.addcollection(collection);
    }

    /**
     * 根据用户ID查询收藏详情
     * @param userId
     * @return
     */
    @Override
    public List<Collection> querycollectionById(String userId) {
        return mapper.querycollectionById(userId);
    }

    /**
     * 根据workId查询work详情，或者根据用户ID查询用户已发布的招聘信息
     * @param workid
     * @param userid
     * @return
     */
    @Override
    public List<Work> workById(String workid, String userid) {
        return mapper.workById(workid,userid);
    }
    /**
     * 根据workid修改work
     * @param work
     */
    @Override
    public void modifywork(Work work) {
        mapper.modifywork(work);
    }
    /**
     * 删除已发布的招聘信息
     */
    @Override
    public void deletework(String workid) {
        mapper.deletework(workid);
    }

    /**
     * 删除收藏的招聘信息
     */
    @Override
    public void deletecollectionwork(String workid) {
        mapper.deletecollectionwork(workid);
    }
    /**
     * 查询所有领域
     */
    @Override
    public List<Work> worktypequery() {
        return mapper.worktypequery();
    }
    /**
     * 查询所有领工作类别
     */
    public List<Work> workposttypequery(){
        return mapper.workposttypequery();
    }
    /**
     * 查询所有城市
     */
    public List<Work> workcityquery(){
        return mapper.workcityquery();
    }

}
