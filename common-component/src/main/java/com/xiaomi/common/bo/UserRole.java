package com.xiaomi.common.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Lukas He
 * @create: 2020-09-25 11:07
 **/
@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = -7354049823071961630L;

    private String role;
    private String description;
    private List<String> permission;
}
