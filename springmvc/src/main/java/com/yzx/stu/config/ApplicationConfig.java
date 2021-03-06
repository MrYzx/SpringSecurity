package com.yzx.stu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration //相当于applicationContext.xml，它对应web.xml中ContextLoaderListener的配置
@ComponentScan(basePackages = "com.yzx.stu"
            ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
