package com.xiaomi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hekun
 */
@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
