package com.xiaomi.permission.service.impl;

import com.xiaomi.permission.repository.SysPermissionRepository;
import com.xiaomi.permission.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: permission-service
 * @description:
 * @author: hekun
 * @create: 2020-09-25 10:51
 **/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository permissionRepository;

    @Override
    public Boolean hasRight(Integer userId, String permission) {
        Integer permissionId = permissionRepository.hasRight(userId, permission);
        if (permissionId != null){
            return true;
        }
        return false;
    }
}
