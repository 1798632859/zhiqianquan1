package com.huyang.zhiqianquan.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Work;
import com.huyang.zhiqianquan.service.WorkService;
import com.huyang.zhiqianquan.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
public class WorkController {
    @Autowired
    WorkService WorkServiceImpl;

    /**
     * 添加招聘信息
     */
    @RequestMapping("/api/work/add")
    public JsonResult addwork(String workType, String userId, String workImage, String workCompanyName,
                              String workPostName, String workPostType, String workCity,
                              String workEntry, String workCycle, String workResume,
                              String workAddress, String workEmail, String workDesride, String workStatus) {
        JsonResult result = null;
        Work work = new Work();
        work.setWorkId(UUID.randomUUID().toString());
        work.setUserId(UUID.randomUUID().toString());
        work.setWorkType(workType);
        work.setWorkImage(workImage);
        work.setWorkCompanyName(workCompanyName);
        work.setWorkPostName(workPostName);
        work.setWorkPostType(workPostType);
        work.setWorkCity(workCity);
        work.setWorkEntry(workEntry);
        work.setWorkCycle(workCycle);
        work.setWorkResume(workResume);
        work.setWorkAddress(workAddress);
        work.setWorkEmail(workEmail);
        work.setWorkDesride(workDesride);
        work.setWorkData(new Timestamp(System.currentTimeMillis()));
        work.setWorkStatus(workStatus);
        try {
            if (work != null) {
                int i = WorkServiceImpl.addwork(work);
                result = new JsonResult("200", "发布成功", work.getWorkId());
                System.out.println(work);
            } else {
                result = new JsonResult("400", "发布失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "发布异常", e.getMessage());
        }

        return result;
    }

    /**
     * 查询所有招聘信息，带分页，每页8条
     *
     * @return
     */
    @RequestMapping("/api/work/queryall")
    public JsonResult querywork(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize) {
        JsonResult result = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List list = WorkServiceImpl.querywork();
            PageInfo<Map> pageInfo = new PageInfo(list);
            if (pageInfo != null) {
                result = new JsonResult("200", "查询成功", pageInfo);
            } else {
                result = new JsonResult("400", "查询失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "查询异常", e.getMessage());
        }
        return result;
    }

    /**
     * 按照类别查询信息,带分页，每页8条(已测试可代替查询所有)
     */
    @RequestMapping("/api/work/queryvague")
    public JsonResult queryworktype(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize,
                                    String worktype, String workposttype, String workcity, String company) {
        JsonResult result = null;
        Work work = new Work();
        work.setWorkType(worktype);
        work.setWorkPostType(workposttype);
        work.setWorkCity(workcity);
        work.setWorkCompanyName(company);
        try {
            PageHelper.startPage(pageNum, pageSize);
            List list = WorkServiceImpl.queryworktype(work);
            PageInfo<Map> pageInfo = new PageInfo(list);
            if (pageInfo != null) {
                result = new JsonResult("200", "按类别查询成功", pageInfo);
            } else {
                result = new JsonResult("400", "按类别查询失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "按类别查询异常", e.getMessage());
        }

        return result;
    }

    /**
     * 收藏招聘信息
     */
    @RequestMapping("/api/work/collection")
    public JsonResult addcollection(String userId, String workId, String chatroomId) {
        JsonResult result = null;
        Collection collection = new Collection();
        collection.setCollectionId(UUID.randomUUID().toString());
        collection.setUserId(userId);
        collection.setWorkId(workId);
        collection.setChatroomId(chatroomId);
        collection.setCollectionData(new Timestamp(System.currentTimeMillis()));
        collection.setCollectionStatus("1");
        try {
            if (collection != null) {
                WorkServiceImpl.addcollection(collection);
                result = new JsonResult("200", "添加成功", "");
            } else {
                result = new JsonResult("400", "添加失败", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "添加异常", e.getMessage());
        }
        return result;
    }
    /**
     * 根据用户ID查询收藏招聘详情
     * @param userId
     * @return
     */
    @RequestMapping("/api/collection/queryById")
    public JsonResult querycollectionById(String userId){
        JsonResult result = null;
        try{
            List list=WorkServiceImpl.querycollectionById(userId);
            if(list!=null){
                result = new JsonResult("200", "查询收藏成功", list);
            }else{
                result = new JsonResult("400", "查询收藏失败", null);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new JsonResult("500", "查询收藏异常", e.getMessage());
        }
        return result;
    }
    /**
     *根据workId查询work详情，或者根据用户ID查询用户已发布的招聘信息
     *
     */
    @RequestMapping("/api/work/ById")
    public JsonResult workById(String workid, String userid){
        JsonResult result = null;
        try{
            List list=WorkServiceImpl.workById(workid,userid);
            if(list!=null){
                result = new JsonResult("200", "查询招聘信息成功", list);
            }else{
                result = new JsonResult("400", "查询招聘信息失败", null);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new JsonResult("500", "查询招聘信息异常", e.getMessage());
        }
        return result;
    }
    /**
     * 根据workid修改work
     * @param
     */
    @RequestMapping("/api/modify/work")
    public JsonResult modifywork(String workType, String userId, String workImage, String workCompanyName,
                                 String workPostName, String workPostType, String workCity,
                                 String workEntry, String workCycle, String workResume,
                                 String workAddress, String workEmail, String workDesride,String workid){
        JsonResult result = null;
        Work work = new Work();
        work.setWorkId(workid);
        work.setUserId(userId);
        work.setWorkType(workType);
        work.setWorkImage(workImage);
        work.setWorkCompanyName(workCompanyName);
        work.setWorkPostName(workPostName);
        work.setWorkPostType(workPostType);
        work.setWorkCity(workCity);
        work.setWorkEntry(workEntry);
        work.setWorkCycle(workCycle);
        work.setWorkResume(workResume);
        work.setWorkAddress(workAddress);
        work.setWorkEmail(workEmail);
        work.setWorkDesride(workDesride);
        work.setWorkData(new Timestamp(System.currentTimeMillis()));
        try{

            if(work!=null){
                WorkServiceImpl.modifywork(work);
                result=new JsonResult("200","修改成功","");
            }else{
                result=new JsonResult("400","修改失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("500","修改异常",e.getMessage());
        }
        return  result;
    }
    /**
     * 删除已发布的招聘信息
     */
    @RequestMapping("/delete/work/release")
    public JsonResult deletework(String workid){
        JsonResult result = null;
        try{
            WorkServiceImpl.deletework(workid);
            result=new JsonResult("200","删除成功",null);
        }catch(Exception e){
            e.printStackTrace();
            result=new JsonResult("500","删除异常",null);
        }
        return result;
    }
    /**
     * 删除收藏的招聘信息
     */
    @RequestMapping("/delete/work/collection")
    public JsonResult deletecollectionwork(String workid){
        JsonResult result = null;
        try{
            WorkServiceImpl.deletecollectionwork(workid);
            result=new JsonResult("200","删除成功",null);
        }catch(Exception e){
            e.printStackTrace();
            result=new JsonResult("500","删除异常",null);
        }
        return result;
    }
}
