package com.itcodes.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName GoodsApplication  商品操作业务
 * @Author sussen
 * @Version 1.0
 * @Date 2020/5/31
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.itcodes.goods.dao") //通用mapper: Dao接口扫描
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
