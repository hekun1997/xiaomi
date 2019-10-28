package com.xiaomi.configuration.web;

import com.xiaomi.pojo.User;

public class UserThread {
    private static ThreadLocal<User> local = new ThreadLocal<>();

    public static void set(User user){
        local.set(user);
    }

    public static User get(){
        return local.get();
    }

    public static void remove(){
        local.remove();
    }
}
