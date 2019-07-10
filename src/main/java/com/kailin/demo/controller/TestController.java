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

    /**
     * 经测试，入参出现以下情况时，自定义拦截器将不会拦截：
     * 1.Controller接口没有参数
     * 2.ServletRequest类型的参数
     * 3.被@RequestBody修饰的参数
     * 4.类型为Map的参数
     * @param id
     * @return
     */
    @GetMapping("queryData")
    public Map<String,String> queryData(@UserId  String id){
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        return map;
    }
}
