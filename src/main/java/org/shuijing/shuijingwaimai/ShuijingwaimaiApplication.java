package org.shuijing.shuijingwaimai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("org.shuijing.shuijingwaimai.dao")
public class ShuijingwaimaiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShuijingwaimaiApplication.class, args);
        System.out.println("启动成功");
    }

}
