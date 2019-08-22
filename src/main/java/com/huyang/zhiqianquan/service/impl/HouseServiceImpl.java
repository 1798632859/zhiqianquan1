package com.huyang.zhiqianquan.service.impl;

import com.huyang.zhiqianquan.dao.HouseDao;
import com.huyang.zhiqianquan.entity.Chart;
import com.huyang.zhiqianquan.entity.Collection;
import com.huyang.zhiqianquan.entity.House;
import com.huyang.zhiqianquan.entity.Tenancy;
import com.huyang.zhiqianquan.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Primary
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;


    @Override
    public List<House> HouseList(HashMap map) {
        return houseDao.HouseList(map);
    }

    @Override
    public House FindHouseById(String houseId) {
        return houseDao.FindHouseById(houseId);
    }

    @Override
    public List<Chart> FindImageByHouseId(String houseId) {
        return houseDao.FindImageByHouseId(houseId);
    }

    @Override
    public Collection FindHouseCollection(HashMap<String ,Object> map) {
        return houseDao.FindHouseCollection(map);
    }

    @Override
    public int Collection(HashMap<String, Object> map) {
        Collection collection = houseDao.FindHouseCollection(map);
        if(collection==null){
            return houseDao.Collection(map);
        }else{
            if("0".equals(collection.getCollectionStatus())){
                return houseDao.ReCollection(map);
            }else{
                return 3;
            }
        }



    }


    @Override
    public int ReleaseHouse(House house) {
        return houseDao.ReleaseHouse(house);
    }

    @Override
    public int RelesaseHouseImage(HashMap<String, Object> chartMap) {
        return houseDao.RelesaseHouseImage(chartMap);
    }


    @Override
    public int UploadImage(Chart chart) {
        return houseDao.UploadImage(chart);
    }

    @Override
    public int ReportHouse(HashMap<String, Object> reportMap) {
        return houseDao.ReportHouse(reportMap);
    }

    @Override
    public List<Tenancy> likefind(String pattern) {
        return houseDao.likefind(pattern);
    }


}
