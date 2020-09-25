package com.xiaomi.common.bo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: demo
 * @description:
 * @author: Lukas He
 * @create: 2020-09-25 14:11
 **/
@Data
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 4858008819073081783L;

    private String username;
    private String password;
    private String phone;
    private String question;
    private String answer;
    private Integer role;
    private Date createTime;
}
