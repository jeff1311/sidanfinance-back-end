package com.ljf.sidanfinance;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableScheduling
@MapperScan("com.ljf.sidanfinance.dao.mapper")
@ServletComponentScan(basePackages = {"com.ljf.sidanfinance.filter"}) //这一句完成了配置，Springboot的”懒理念“真的厉害。
@SpringBootApplication
public class SidanFinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidanFinanceApplication.class, args);
    }

}
