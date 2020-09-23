package com.xiaomi.service.shiroService;

import java.util.Set;

public interface RoleService {
    Set<String> getRoleByUsername(String username);
}
