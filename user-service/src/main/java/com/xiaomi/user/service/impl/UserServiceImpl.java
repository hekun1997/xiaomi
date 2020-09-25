package com.xiaomi.user.service.impl;

import com.xiaomi.common.bo.User;
import com.xiaomi.common.bo.UserLoginBody;
import com.xiaomi.user.repository.UserRepository;
import com.xiaomi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description:
 * @author: hekun
 * @create: 2020-09-25 14:09
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean checkUserExists(String username) {
        Integer id = userRepository.findUserByName(username);
        if (id == null){
            return true;
        }
        return false;
    }

    @Override
    public User login(UserLoginBody loginBody) {


        return null;
    }
}
