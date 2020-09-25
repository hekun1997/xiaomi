package com.xiaomi.common.bo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo
 * @description:
 * @author: Lukas He
 * @create: 2020-09-25 14:12
 **/
@Data
@Builder
public class UserLoginBody implements Serializable {
    private static final long serialVersionUID = -2942896058758235964L;
    private String username;
    private String password;
    private String phone;
}
