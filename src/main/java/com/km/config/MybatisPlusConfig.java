package com.km.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//这个很重要
public class MybatisPlusConfig {

    //配置逻辑删除,mybatis-plus自带的
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    //配置分页，mybatis-plus自带的
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();

    }


}
