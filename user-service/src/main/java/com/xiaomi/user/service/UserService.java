package com.xiaomi.user.service;

import com.xiaomi.common.bo.User;
import com.xiaomi.common.bo.UserLoginBody;

public interface UserService {

    Boolean checkUserExists(String username);

    User login(UserLoginBody loginBody);
}
