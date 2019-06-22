package com.kailin.demo.controller;

import com.kailin.demo.common.Result;
import com.kailin.demo.common.ResultGenerator;
import com.kailin.demo.entity.Area;
import com.kailin.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/list")
    public Result listArea(){
        List<Area> areaList = areaService.getAreaList();
        return ResultGenerator.genSuccessResult(areaList);
    }

    @GetMapping("/getById")
    public Result getById(@NotNull Long areaId){
        Area area = areaService.getById(areaId);
        return ResultGenerator.genSuccessResult(area);
    }

    @PostMapping("/add")
    public Result addArea(@Valid Area area){
        area.setCreateTime(new Date());
        area.setLastEditTime(area.getCreateTime());
        int i = areaService.saveArea(area);
        if (i == 1) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加失败");
    }

    @GetMapping("/deleteById")
    public Result deleteArea(@NotNull Long areaId) {
        int i = areaService.deleteById(areaId);
        if (i == 1) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除失败");
    }
}
