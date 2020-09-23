package com.xiaomi.user.service;

import java.util.Set;

public interface PermissionService {
    Set<String> getPermissionByUsername(String username);
}
