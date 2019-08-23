package com.huyang.zhiqianquan.service;

import com.huyang.zhiqianquan.entity.Chart;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.House;
import com.huyang.zhiqianquan.entity.Tenancy;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface HouseService {
    //查询房源列表
    public List<House> HouseList(HashMap map);
    //按照房源ID查询房源详情
    public House FindHouseById(String houseId);
    //按照房源ID查询房源图片
    public List<Chart> FindImageByHouseId(String houseId);
    //按照用户ID查询收藏的房源
    public Collection FindHouseCollection(HashMap<String, Object> map);
    //按照房源ID收藏
    public int Collection(HashMap<String, Object> map);
    //发布房源信息
    public int ReleaseHouse(House house);
    //发布房源信息图片
    public int RelesaseHouseImage(HashMap<String, Object> chartMap);
    //上传房源图片
    public int UploadImage(Chart chart);
    //举报房源
    public int ReportHouse(HashMap<String, Object> reportMap);
    //
    List<House> likefind(String pattern);

    //后台删除房源
    int DeleteHouse(@Param("houseId") String houseId);
}
