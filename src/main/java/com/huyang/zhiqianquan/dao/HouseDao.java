package com.huyang.zhiqianquan.dao;


import com.huyang.zhiqianquan.entity.Chart;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.House;
import com.huyang.zhiqianquan.entity.Tenancy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface HouseDao {
    //查询房源列表
    public List<House> HouseList(HashMap map);
    //按照房源ID查询房源详情
    public House FindHouseById(String houseId);
    //按照房源ID查询房源图片
    public List<Chart> FindImageByHouseId(String houseId);
    //按照用户ID查询是否收藏房源
    public Collection FindHouseCollection(HashMap<String, Object> map);
    //按照房源ID收藏
    public int Collection(HashMap<String, Object> map);
    //取消收藏
    public int UpdateCollection(String houseId, String userId);
    //重新收藏
    public int ReCollection(HashMap<String, Object> map);
    //发布房源信息
    public int ReleaseHouse(House house);
    //发布房源信息图片
    public int RelesaseHouseImage(HashMap<String, Object> chartMap);
    //上传房源图片
    public int UploadImage(Chart chart);
    //举报房源
    public int ReportHouse(HashMap<String, Object> reportMap);
    //模糊查询
    List<House> likefind(@Param("pattern") String pattern);
    //后台删除房源
    int DeleteHouse(@Param("houseId") String houseId);
}
