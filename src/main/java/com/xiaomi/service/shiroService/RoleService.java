package com.xiaomi.service.shiroService;

import com.xiaomi.pojo.shiro.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<String> getRoleByUsername(String username);
}
