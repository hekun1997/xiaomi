package com.xiaomi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ImportResource(locations = "classpath:kaptcha.xml")
@ServletComponentScan(basePackages = "com.xiaomi.configuration.web")
@EnableWebMvc
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.xiaomi.dao")
@SpringBootApplication
public class XiaomiApplication {

    public static void main(String[] args) {
        SpringApplication.run( XiaomiApplication.class, args);
    }

}
