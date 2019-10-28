package com.xiaomi.service.shiroService;

import com.xiaomi.pojo.shiro.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    Set<String> getPermissionByUsername(String username);
}
