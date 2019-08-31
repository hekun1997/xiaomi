package com.xiaomi.service;

import com.xiaomi.dao.UserMapperProvider;
import com.xiaomi.pojo.User;

public interface UserService {

    User login(String username, String password);

    Integer checkUsername(String username);

    User getUserById(Integer id);

    int register(User user);

    int UpdateUser(User user);
}
