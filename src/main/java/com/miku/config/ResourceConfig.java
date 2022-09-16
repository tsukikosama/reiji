package com.miku.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletContext;

/**
 * 这个配置类用来指定静态资源访问的路径 可以用配置类来实现 也可以使用配置文件来实现
 */
@Slf4j
@Configuration
public class ResourceConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("静态资源配置开始生效");
        //addResourceHandler用来添加静态资源的路径
        //addResourceLocations 用来映射的资源路径
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
    }

}
