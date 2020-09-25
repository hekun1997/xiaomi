package com.xiaomi.permission.service;

/**
 * @author Lukash
 */
public interface SysPermissionService {

    /**
     * 判断用户是否有某项权限
     * @param userId
     * @param permission
     * @return
     */
    Boolean hasRight(Integer userId, String permission);
}
