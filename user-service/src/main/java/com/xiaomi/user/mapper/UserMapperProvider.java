package com.xiaomi.user.mapper;

import com.xiaomi.pojo.User;
import org.springframework.util.StringUtils;

/**
 * @author hekun
 */
public class UserMapperProvider {

    public String UpdateUser(User user){
        StringBuilder sql = new StringBuilder("update user set ");

        String username = user.getUsername();
        String password = user.getPassword();
        String tel = user.getTel();
        String signature = user.getSignature();
        String hobby = user.getHobby();
        String address = user.getAddress();

        if (StringUtils.hasText(username)) {
            sql.append("username = #{username}");
        }
        if (StringUtils.hasText(password)) {
            sql.append(",password = #{password}");
        }
        if (StringUtils.hasText(tel)) {
            sql.append(",tel = #{tel}");
        }
        if (StringUtils.hasText(signature)) {
            sql.append(",signature = #{signature}");
        }
        if (StringUtils.hasText(hobby)) {
            sql.append(",hobby = #{hobby}");
        }
        if (StringUtils.hasText(address)) {
            sql.append(",address = #{address}");
        }

        sql.append(" where id = #{id}");
        return sql.toString();
    }
}
