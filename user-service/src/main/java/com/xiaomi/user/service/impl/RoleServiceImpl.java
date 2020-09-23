package com.xiaomi.user.service.impl;

import com.xiaomi.dao.shiroMapper.RoleMapper;
import com.xiaomi.pojo.shiro.Role;
import com.xiaomi.service.shiroService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> getRoleByUsername(String username) {
        List<Role> roleList = roleMapper.getRoleByUsername(username);
        Set<String> roleSet = new HashSet<>();
        for (Role role : roleList){
            roleSet.add(role.getName());
        }
        return roleSet;
    }
}
