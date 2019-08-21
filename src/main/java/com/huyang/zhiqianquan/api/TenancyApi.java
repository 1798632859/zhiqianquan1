package com.huyang.zhiqianquan.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.Tenancy;
import com.huyang.zhiqianquan.service.TenancyService;
import com.huyang.zhiqianquan.util.IdUtil;
import com.huyang.zhiqianquan.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class TenancyApi {
    /**
     * 查询所有求组消息(带分页)
     * @return
     */
    @Autowired
    TenancyService TenancyServiceiml;
    @Value("${web.upload.image-path-two}")
    private String uploadpath1;

    @RequestMapping("/api/tenancy/findall")
    public JsonResult findqiuzuall(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize)
    {


        JsonResult json=null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Tenancy> list = TenancyServiceiml.findqiuzuall();
            if (list != null) {
                PageInfo pageInfo = new PageInfo(list);
                json = new JsonResult("200", "查询成功", pageInfo);
                return json;
            } else {
                json = new JsonResult("404", "查询失败", "");
                return json;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;

        }

    }
    /**
     * 多条件查询求组消息(带分页)
     *
     */
    @RequestMapping("/api/tenancy/morefind")
    public JsonResult findqiuzumore(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize,
            @RequestParam(value = "tenancyType", required = true, defaultValue = "") String tenancyType,
            @RequestParam(value = "tenancyPrice", required = true, defaultValue = "") String tenancyPrice,
            @RequestParam(value = "tenancyRegion", required = true, defaultValue = "") String tenancyRegion)
    {

       JsonResult json=null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Tenancy> list = TenancyServiceiml.findqiuzumore(tenancyType,tenancyRegion,tenancyPrice);
            if (list != null) {
                PageInfo pageInfo = new PageInfo(list);
                json = new JsonResult("200", "查询成功", pageInfo);
                return json;
            } else {
                json = new JsonResult("404", "查询失败", "");
                return json;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 发布求租消息
     *
     */
    @RequestMapping("/api/tenancy/addtenancy")
    public JsonResult addtenancy(
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "tenancyLivetime", required = true) String tenancyLivetime,
            @RequestParam(value = "tenancyType", required = true) String tenancyType,
            @RequestParam(value = "tenancy_Requestsex", required = true) String tenancy_Requestsex,
            @RequestParam(value = "tenancyCity", required = true) String tenancyCity,
            @RequestParam(value = "tenancyRegion", required = true) String tenancyRegion,
            @RequestParam(value = "tenancyPosition", required = true) String tenancyPosition,
            @RequestParam(value = "tenancyPrice", required = true) long tenancyPrice,
            @RequestParam(value = "tenancyPhone", required = true) String tenancyPhone,
            @RequestParam(value = "tenancyLabel", required = true) String tenancyLabel,
            @RequestParam(value = "tenancyCommed", required = true) String tenancyCommed
            ) {

        Tenancy tenancy=new Tenancy();
        String id= IdUtil.getUuid();

        tenancy.setTenancyId(id);
        tenancy.setUserId(userId);
        tenancy.setTenancyType(tenancyType);
        tenancy.setTenancy_Requestsex(tenancy_Requestsex);
        tenancy.setTenancyCity(tenancyCity);
        tenancy.setTenancyRegion(tenancyRegion);
        tenancy.setTenancyPosition(tenancyPosition);
        tenancy.setTenancyPrice(tenancyPrice);
        tenancy.setTenancyPhone(tenancyPhone);
        tenancy.setTenancyLabel(tenancyLabel);
        tenancy.setTenancyCommed(tenancyCommed);
        tenancy.setTenancyFounddata(new Timestamp(System.currentTimeMillis()));
        tenancy.setTenancyLivetime(Timestamp.valueOf(tenancyLivetime));

        JsonResult json=null;
        try {
                TenancyServiceiml.addtenancy(tenancy);
                json = new JsonResult("200", "插入成功", null);
                return json;

        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 模糊查询求租信息
     *
     */
    @RequestMapping("/api/tenancy/likefind")
    public JsonResult likefind(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize,
            @RequestParam(value = "pattern", required = true) String pattern)
    {

        JsonResult json=null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Tenancy> list = TenancyServiceiml.likefind(pattern);
            if (list != null) {
                PageInfo pageInfo = new PageInfo(list);
                json = new JsonResult("200", "查询成功", pageInfo);
                return json;
            } else {
                json = new JsonResult("404", "查询失败", "");
                return json;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 根据id查询求租信息
     *
     */
    @RequestMapping("/api/tenancy/finduserall")
    public JsonResult finduserall(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize,
            @RequestParam(value = "userId", required = true) String userId)
    {

        JsonResult json=null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Tenancy> list = TenancyServiceiml.finduserall(userId);
            if (list != null) {
                PageInfo pageInfo = new PageInfo(list);
                json = new JsonResult("200", "查询成功", pageInfo);
                return json;
            } else {
                json = new JsonResult("404", "查询失败", "");
                return json;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 修改求租信息
     *
     */
    @RequestMapping("/api/tenancy/updatetenancy")
    public JsonResult updatetenancy(
            @RequestParam(value = "tenancyId", required = true) String tenancyId,
            @RequestParam(value = "tenancyLivetime", required = true) String tenancyLivetime,
            @RequestParam(value = "tenancyType", required = true) String tenancyType,
            @RequestParam(value = "tenancy_Requestsex", required = true) String tenancy_Requestsex,
            @RequestParam(value = "tenancyCity", required = true) String tenancyCity,
            @RequestParam(value = "tenancyRegion", required = true) String tenancyRegion,
            @RequestParam(value = "tenancyPosition", required = true) String tenancyPosition,
            @RequestParam(value = "tenancyPrice", required = true) long tenancyPrice,
            @RequestParam(value = "tenancyPhone", required = true) String tenancyPhone,
            @RequestParam(value = "tenancyLabel", required = true) String tenancyLabel,
            @RequestParam(value = "tenancyCommed", required = true) String tenancyCommed
    ) {
            Tenancy tenancy=new Tenancy();
            tenancy.setTenancyId(tenancyId);
            tenancy.setTenancyLivetime(Timestamp.valueOf(tenancyLivetime));
            tenancy.setTenancyCommed(tenancyCommed);
            tenancy.setTenancyLabel(tenancyLabel);
            tenancy.setTenancyPhone(tenancyPhone);
            tenancy.setTenancyRegion(tenancyRegion);
            tenancy.setTenancyPrice(tenancyPrice);
            tenancy.setTenancyPosition(tenancyPosition);
            tenancy.setTenancyCity(tenancyCity);
            tenancy.setTenancy_Requestsex(tenancy_Requestsex);
            tenancy.setTenancyType(tenancyType);

        JsonResult json=null;
        try {
            TenancyServiceiml.updatetenancy(tenancy);
            json = new JsonResult("200", "插入成功", null);
            return json;

        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 删除求租消息
     *
     */
    @RequestMapping("/api/tenancy/deletetenancy")
    public JsonResult deletetenancy(
            @RequestParam(value = "tenancyId", required = true) String tenancyId,
            @RequestParam(value = "userId", required = true) String userId)
    {

        JsonResult json=null;
        try {

           TenancyServiceiml.deletetenancy(tenancyId,userId);
                json = new JsonResult("200", "删除成功", "");
                return json;

        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 点赞求租消息
     *
     */
    @RequestMapping("/api/tenancy/Fabuloustenancy")
    public JsonResult Fabuloustenancy(
            @RequestParam(value = "tenancyId", required = true) String tenancyId)
    {
        JsonResult json=null;
        try {
            TenancyServiceiml.Fabuloustenancy(tenancyId);
            json = new JsonResult("200", "点赞成功", "");
            return json;

        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 收藏求租消息
     *
     */
    @RequestMapping("/api/tenancy/inserttenancy")
    public JsonResult inserttenancy(
            @RequestParam(value = "tenancyId", required = true) String tenancyId,
             @RequestParam(value = "userId", required = true) String userId)
    {
        Collection collection=new Collection();
        String id=IdUtil.getUuid();
        collection.setTenancyId(tenancyId);
        collection.setUserId(userId);
        collection.setCollectionId(id);
        collection.setCollectionData(new Timestamp(System.currentTimeMillis()));
        JsonResult json=null;
        try {

            TenancyServiceiml.inserttenancy(collection);
            json = new JsonResult("200", "收藏成功", "");
            return json;

        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 查询是否收藏当前求租信息
     *
     */
    @RequestMapping("/api/tenancy/selectcollextion")
    public JsonResult selectcollextion(
            @RequestParam(value = "tenancyId", required = true) String tenancyId,
            @RequestParam(value = "userId", required = true) String userId)
    {
        JsonResult json=null;
        Collection collection=null;
        try {
           collection=TenancyServiceiml.selectcollextion(tenancyId,userId);

            if(collection!=null) {
                json = new JsonResult("200", "查询收藏成功", collection);
            }else{
                collection.setCollectionStatus("0");
                json = new JsonResult("200", "查询收藏成功", collection);
            }
            return json;

        } catch (Exception ex) {
            ex.printStackTrace();
            json = new JsonResult("500", "error", "");
            return json;
        }
    }
    /**
     * 举报
     * @param tenancyId
     * @param reportDetails
     * @param file
     * @return
     */
    @RequestMapping("/report")
    public JsonResult ReportHouse(String tenancyId,String reportDetails,@RequestParam(value = "file") MultipartFile[] file){
        JsonResult result=null;


        HashMap<String ,Object> map = new HashMap<>();
        if(file.length!=0){
            for(int i =0;i<file.length;i++){
                String[] fileName = file[i].getOriginalFilename().split("\\.");
                try {
                    String filename=IdUtil.getUuid().toString().replaceAll("-","");
                    file[i].transferTo(new File(uploadpath1+"\\"+filename+"."+fileName[1]));
                    String index = "reportImage"+(i+1);
                    System.out.println(index);
                    map.put(index,filename);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        try {
            map.put("reportId",IdUtil.getUuid().toString());
            map.put("houseId",tenancyId);
            map.put("reportDetails",reportDetails);
            map.put("reportTime",new Timestamp(System.currentTimeMillis()));
            int i = TenancyServiceiml.ReportHouse(map);
            if(i==1){
                result = new JsonResult("举报成功","200","");
            }else{
                result = new JsonResult("举报失败","500","");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result = new JsonResult("举报异常","404","");
        }
        return result;
    }

}
