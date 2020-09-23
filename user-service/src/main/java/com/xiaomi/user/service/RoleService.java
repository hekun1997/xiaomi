package com.xiaomi.user.service;

import java.util.Set;

public interface RoleService {
    Set<String> getRoleByUsername(String username);
}
