package com.km;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication//这里面coponentScan，他不显示声明扫描那个包，就是默认当前包及其所有子包
// 开启 servlet 扫描
@ServletComponentScan//这个好像没见过，这是它验证码第二种方式的处理，可以不写,Xxxscan都是一个套路
//plus,原生mybatis，都是下面这个，tk-mapper，好像不是下面这个扫描，但都要写
@MapperScan(basePackages = "com.km.mapper")//@MapperScan("com.km.mapper")这两个一样
public class SpringBootThemeleafDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootThemeleafDemoApplication.class, args);
    }

}
