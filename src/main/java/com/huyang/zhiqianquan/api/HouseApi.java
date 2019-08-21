package com.huyang.zhiqianquan.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyang.zhiqianquan.entity.Chart;
import com.huyang.zhiqianquan.entity.House;
import com.huyang.zhiqianquan.entity.Tenancy;
import com.huyang.zhiqianquan.service.HouseService;
import com.huyang.zhiqianquan.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/house")
public class HouseApi {

    @Autowired
    private HouseService houseService;
    @Value("${web.upload.image-path}")
    private String uploadpath;
    @Value("${web.upload.image-path-two}")
    private String uploadpath1;
    /**
     * 查询房源列表(带分页和筛选)
     * @param pageNum
     * @param pageSize
     * @param houseType
     * @param houseAtcity
     * @param houseRegion
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @RequestMapping("/list")
    public JsonResult HouseList(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize,
                                     String houseType,String houseAtcity,String houseRegion,Integer minPrice,Integer maxPrice
                                ){
        JsonResult result=null;
        try {
            HashMap<String , Object> map = new HashMap<>();
            map.put("houseType",houseType);
            map.put("houseAtcity",houseAtcity);
            map.put("houseRegion",houseRegion);
            map.put("minPrice",minPrice);
            map.put("maxPrice",maxPrice);
            PageHelper.startPage(pageNum, pageSize);
            List<House> list = houseService.HouseList(map);
            PageInfo<Map> pageInfo = new PageInfo(list);
            if(list!=null){
                result = new JsonResult("查询成功","200",pageInfo);
            }else {
                result = new JsonResult("查询失败","404","");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result = new JsonResult("查询异常","500","");
        }
        return result;
    }

    /**
     * 房源Id查询房源详情
     * @param houseId
     * @return
     */
    @RequestMapping("/findById")
    public JsonResult FindHouseById(String houseId){
        JsonResult result = null;
        try {
            List<Chart> list = houseService.FindImageByHouseId(houseId);
            House house = houseService.FindHouseById(houseId);
            house.setChart(list);
            if(house!=null){
                result = new JsonResult("查询成功","200",house);
            }else{
                result = new JsonResult("查询失败","404","");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result = new JsonResult("查询异常","500","");
        }
        return result;
    }

    /**
     * 收藏房源
     * @param houseId
     * @param userId
     * @return
     */
    @RequestMapping("/collection")
    public JsonResult collection(String houseId,String userId){
        JsonResult result = null;
        HashMap<String ,Object> map = new HashMap<>();
        try {
            map.put("collectionId", UUID.randomUUID().toString());
            map.put("userId",userId);
            map.put("houseId",houseId);
            map.put("collectionData",new Timestamp(System.currentTimeMillis()));
            int i = houseService.Collection(map);
            if(i==1){
                result = new JsonResult("收藏成功","200","");
            }else{
                result = new JsonResult("收藏失败","404","");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result = new JsonResult("系统异常","500","");
        }
        return result;
    }

    /**
     * 发布房源
     * @param house
     * @param file
     * @return
     */
    @RequestMapping("/release")
    public JsonResult ReleaseHouse(House house,
           @RequestParam(value = "file")MultipartFile[] file){
        JsonResult result = null;
        HashMap<String ,Object> chartMap = new HashMap<>();
        house.setHouseId(UUID.randomUUID().toString());
        if(file.length!=0){
            for(int i =0;i<file.length;i++){
                String[] fileName = file[i].getOriginalFilename().split("\\.");
                try {
                    String filename=UUID.randomUUID().toString().replaceAll("-","");
                    file[i].transferTo(new File(uploadpath+"\\"+filename+"."+fileName[1]));
                    chartMap.put("chartId",UUID.randomUUID().toString());
                    chartMap.put("houseId",house.getHouseId());
                    chartMap.put("imageName",filename);
                    int imageI = houseService.RelesaseHouseImage(chartMap);
                    house.setHouseTime(new Timestamp(System.currentTimeMillis()));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
       try {
           int releaseI = houseService.ReleaseHouse(house);
            if(releaseI==1){
                result = new JsonResult("发布成功","200","");
            }else{
                result = new JsonResult("发布失败","500","");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result = new JsonResult("发布异常","404","");
        }
        return result;
    }

    /**
     * 举报
     * @param houseId
     * @param reportDetails
     * @param file
     * @return
     */
    @RequestMapping("/report")
    public JsonResult ReportHouse(String houseId,String reportDetails,@RequestParam(value = "file")MultipartFile[] file){
        JsonResult result=null;
        HashMap<String ,Object> map = new HashMap<>();
        if(file.length!=0){
            for(int i =0;i<file.length;i++){
                String[] fileName = file[i].getOriginalFilename().split("\\.");
                try {
                    String filename=UUID.randomUUID().toString().replaceAll("-","");
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
            map.put("reportId",UUID.randomUUID().toString());
            map.put("houseId",houseId);
            map.put("reportDetails",reportDetails);
            map.put("reportTime",new Timestamp(System.currentTimeMillis()));
            int i = houseService.ReportHouse(map);
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

    /**
     * 模糊查询求租信息
     *
     */
    @RequestMapping("/likefind")
    public JsonResult likefind(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "8") Integer pageSize,
            @RequestParam(value = "pattern", required = true) String pattern)
    {

        JsonResult json=null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Tenancy> list = houseService.likefind(pattern);
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


}
