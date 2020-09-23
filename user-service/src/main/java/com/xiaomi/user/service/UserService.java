package com.xiaomi.user.service;

import com.xiaomi.common.bo.User;

public interface UserService {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    Integer checkUsername(String username);

    User getUserById(Integer id);

    int register(User user);

    int updateUser(User user);
}
