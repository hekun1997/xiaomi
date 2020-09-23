package com.xiaomi.dao.shiroMapper;

import com.xiaomi.pojo.shiro.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hekun
 */
@Repository
public interface PermissionMapper {

    @Select("select * from user u " +
            "LEFT JOIN user_role ur on ur.uid = u.id " +
            "LEFT JOIN role r on r.id = ur.rid " +
            "LEFT join role_permission rp on rp.rid = r.id " +
            "LEFT JOIN permission p on p.id = rp.pid " +
            "where username = #{username}")
    List<Permission> getPermissionByUsername(@Param("username") String username);
}
