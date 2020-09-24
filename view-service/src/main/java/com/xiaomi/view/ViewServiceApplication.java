package com.xiaomi.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hekun
 */
@SpringBootApplication
@EnableEurekaClient
public class ViewServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ViewServiceApplication.class, args);
    }
}
