package com.xiaomi.permission.service.impl;

import com.xiaomi.common.bo.UserRole;
import com.xiaomi.permission.entity.SysPermission;
import com.xiaomi.permission.entity.SysRole;
import com.xiaomi.permission.repository.SysPermissionRepository;
import com.xiaomi.permission.repository.SysRolePermissionRepository;
import com.xiaomi.permission.repository.SysRoleRepository;
import com.xiaomi.permission.repository.SysUserRoleRepository;
import com.xiaomi.permission.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lukash
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleRepository roleRepository;
    @Autowired
    private SysRolePermissionRepository rolePermissionRepository;
    @Autowired
    private SysPermissionRepository permissionRepository;
    @Autowired
    private SysUserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findUserRoleByUserId(Integer userId) {
        List<Integer> roleIds = userRoleRepository.findRoleIdsByUserId(userId);
        List<SysRole> roles = roleRepository.findAllById(roleIds);
        List<Integer> permissionIds = rolePermissionRepository.findPermissionIdByRoleId(Arrays.asList(userId));
        List<SysPermission> permissions = permissionRepository.findAllById(permissionIds);


        return null;
    }
}
