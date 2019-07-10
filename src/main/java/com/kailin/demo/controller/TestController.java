package com.kailin.demo.controller;

import com.kailin.demo.annotation.UserId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("queryData")
    public Map<String,String> queryData(@UserId  String id){
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        return map;
    }
}
