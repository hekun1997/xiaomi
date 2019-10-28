package com.xiaomi.ServiceImpl.shiroServiceImpl;

import com.xiaomi.dao.shiroMapper.PermissionMapper;
import com.xiaomi.pojo.shiro.Permission;
import com.xiaomi.service.shiroService.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public Set<String> getPermissionByUsername(String username) {
        List<Permission> permissionList = permissionMapper.getPermissionByUsername(username);
        Set<String> permissionSet = new HashSet<>();

        for (Permission permission : permissionList){
            permissionSet.add(permission.getName());
        }
        return permissionSet;
    }
}
