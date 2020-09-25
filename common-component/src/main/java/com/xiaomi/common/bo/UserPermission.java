package com.xiaomi.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo
 * @description:
 * @author: Lukas He
 * @create: 2020-09-25 11:07
 **/
@Data
public class UserPermission implements Serializable {
    private static final long serialVersionUID = -8094140956361952287L;

    private Integer parentId;
    private String parentIds;
    private String permission;
    private String resourceType;
    private String url;
    private String name;
    private String available;
}
