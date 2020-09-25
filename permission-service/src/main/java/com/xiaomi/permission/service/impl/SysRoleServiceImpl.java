package com.xiaomi.permission.service.impl;

import com.xiaomi.common.bo.UserRole;
import com.xiaomi.permission.repository.SysRoleRepository;
import com.xiaomi.permission.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lukash
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleRepository roleRepository;

    @Override
    public List<UserRole> findUserRoleByUserId(Integer userId) {
        return null;
    }
}
