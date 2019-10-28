package com.xiaomi.configuration.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/alipayNotify").setViewName("alipay_notify");
        registry.addViewController("/alipayReturn{id}").setViewName("redirect:/index");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        super.addResourceHandlers(registry);
    }
}
