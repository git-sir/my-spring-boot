package com.kailin.demo.service;

import com.kailin.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Autowired
    AreaService areaService;

    @Test
    public void getAreaList() {
    }

    @Test
    public void saveArea() {
        Area area = new Area();
        area.setAreaName("海珠");
        area.setCreateTime(new Date());
        area.setPriority(1);
        try {
            areaService.saveArea(area);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}