package com.xiaomi.permission.service;

import com.xiaomi.common.bo.UserRole;

import java.util.List;

public interface SysRoleService {

    List<UserRole> findUserRoleByUserId(Integer userId);
}
