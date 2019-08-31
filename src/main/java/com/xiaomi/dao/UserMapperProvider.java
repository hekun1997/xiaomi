package com.xiaomi.dao;

import com.xiaomi.pojo.User;

public class UserMapperProvider {

    public String UpdateUser(User user){
        String sql = "update user set ";

        Integer id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        String tel = user.getTel();
        String signature = user.getSignature();
        String hobby = user.getHobby();
        String address = user.getAddress();

        if (!username.equals("")) sql += "username = #{username}";
        if (!password.equals("")) sql += ",password = #{password}";
        if (!tel.equals("")) sql += ",tel = #{tel}";
        if (!signature.equals("")) sql += ",signature = #{signature}";
        if (!hobby.equals("")) sql += ",hobby = #{hobby}";
        if (!address.equals("")) sql += ",address = #{address}";

        sql += " where id = #{id}";
        return sql;
    }
}
