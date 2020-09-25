package com.xiaomi.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hekun
 */
@SpringBootApplication
@EnableEurekaClient
public class PermissionServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(PermissionServiceApplication.class, args);
    }
}
