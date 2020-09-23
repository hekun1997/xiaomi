package com.xiaomi.service.shiroService;

import java.util.Set;

public interface PermissionService {
    Set<String> getPermissionByUsername(String username);
}
