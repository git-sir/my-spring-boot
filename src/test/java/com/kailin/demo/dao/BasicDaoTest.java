package com.kailin.demo.dao;

import com.kailin.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicDaoTest {

    @Autowired
    AreaDao areaDao;

    @Test
    public void save() {
    }

    @Test
    public void saveBatch() {
        List<Area> list = new ArrayList<Area>();
        Area area1 = new Area();
        area1.setAreaName("area1");
        Area area2 = new Area();
        area2.setAreaName("area2");
        list.add(area1);
        list.add(area2);
        areaDao.saveBatch(list);
    }

    @Test
    public void update() {
    }

    @Test
    public void updateIgnoreNull() {
    }

    @Test
    public void updateBatch() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteBatch() {
        List<Area> list = new ArrayList<Area>();
        Area area1 = new Area();
        area1.setAreaId(13);
        Area area2 = new Area();
        area2.setAreaId(14);
        list.add(area1);
        list.add(area2);
        areaDao.deleteBatch(list);
    }

    @Test
    public void deleteByPK() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void count() {
    }

    @Test
    public void findByPK() {
    }

    @Test
    public void find() {
    }
}