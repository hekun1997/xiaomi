package com.xiaomi.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hekun
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
