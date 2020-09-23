package com.xiaomi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ImportResource(locations = "classpath:kaptcha.xml")
@ServletComponentScan(basePackages = "com.xiaomi.configuration.web")
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.xiaomi.dao")
@SpringBootApplication
public class XiaomiApplication {

    public static void main(String[] args) {
        SpringApplication.run( XiaomiApplication.class, args);
    }

}
