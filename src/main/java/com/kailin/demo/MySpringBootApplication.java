package com.kailin.demo;

import com.kailin.demo.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @Autowired
    AreaService areaService;

    @Override
    public void run(String... args){
        log.info(">>>>>>>>>>>>>>>服务成功启动后，在这里执行后续操作<<<<<<<<<<<<<");
    }
}
