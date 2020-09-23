package com.xiaomi.common.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hekun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String signature;
    private String hobby;
    private String address;

    /**
     * 用于储存登录信息
     * @param id
     * @param username
     */
    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    /**
     * 用于注册时使用
     * @param username
     * @param password
     * @param tel
     */
    public User(String username, String password, String tel) {
        this.username = username;
        this.password = password;
        this.tel = tel;
    }

    public User(String username, String password, String tel, String signature, String hobby, String address) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.signature = signature;
        this.hobby = hobby;
        this.address = address;
    }
}
