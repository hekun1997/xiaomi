package com.xiaomi.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String signature;
    private String hobby;
    private String address;

    public User() {
    }

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

    public User(Integer id, String username, String password, String tel, String signature, String hobby, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.signature = signature;
        this.hobby = hobby;
        this.address = address;
    }

    public User(String username, String password, String tel, String signature, String hobby, String address) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.signature = signature;
        this.hobby = hobby;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", signature='" + signature + '\'' +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
