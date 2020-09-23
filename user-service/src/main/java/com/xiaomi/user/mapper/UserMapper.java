package com.xiaomi.user.mapper;

import com.xiaomi.common.bo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * @author hekun
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);

    @Select("select count(username) from user where username = #{username}")
    Integer checkUsername(@Param("username") String username);

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);

    @Insert("insert into user (username,password,tel,signature,hobby,address) " +
            "values (#{username},#{password},#{tel},#{signature},#{hobby},#{address})")
    int register(User user);

    @UpdateProvider(type = UserMapperProvider.class,method = "UpdateUser")
    int updateUser(User user);
}