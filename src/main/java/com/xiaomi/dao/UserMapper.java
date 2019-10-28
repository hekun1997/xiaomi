package com.xiaomi.dao;

import com.github.pagehelper.Page;
import com.xiaomi.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(@Param("username")String username, @Param("password")String password);

    @Select("select count(username) from user where username = #{username}")
    Integer checkUsername(@Param("username")String username);

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id")Integer id);

    @Insert("insert into user (username,password,tel,signature,hobby,address) " +
            "values (#{username},#{password},#{tel},#{signature},#{hobby},#{address})")
    int register(User user);

    @UpdateProvider(type = UserMapperProvider.class,method = "UpdateUser")
    int UpdateUser(User user);

    @Select("select * from user")
    Page<User> getUserList();

    @Select("select * from user")
    List<User> getAllUser();
}