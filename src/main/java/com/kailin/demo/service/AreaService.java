package com.kailin.demo.service;

import com.kailin.demo.dao.AreaDao;
import com.kailin.demo.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaDao areaDao;

    public List<Area> getAreaList(){
        List<Area> areaList = areaDao.find(null);
        return areaList;
    }

    @Transactional(rollbackFor = Exception.class)
    public int saveArea(Area area) {
        return areaDao.save(area);
    }
}
