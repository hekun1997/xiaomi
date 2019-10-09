package com.xiaomi.configuration.shiro;

import com.xiaomi.pojo.User;
import com.xiaomi.service.UserService;
import com.xiaomi.service.shiroService.PermissionService;
import com.xiaomi.service.shiroService.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpSession;
import java.util.Set;

public class DataBaseRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = SecurityUtils.getSubject().getPrincipal().toString();

        Set<String> roles = roleService.getRoleByUsername(username);
        Set<String> permissions = permissionService.getPermissionByUsername(username);

        info.setRoles(roles);
        info.setStringPermissions(permissions);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        String password = new String((char[])authenticationToken.getCredentials());

        User user = null;
        try{
            user = userService.login(username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (null == user) throw new AuthenticationException();

        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
