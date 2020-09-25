package com.xiaomi.view.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-service")
public interface UserServiceClient {


}
