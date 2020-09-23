package com.xiaomi.user.mapper;

import com.xiaomi.common.bo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hekun
 */
@Repository
public interface RoleMapper {

    @Select("select r.id,r.name from user u " +
            "left join user_role ur on ur.uid = u.id " +
            "left JOIN role r on r.id = ur.rid " +
            "where u.username = #{username}")
    List<Role> getRoleByUsername(@Param("username") String username);
}
