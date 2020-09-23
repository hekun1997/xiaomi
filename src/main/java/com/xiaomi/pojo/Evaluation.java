package com.xiaomi.pojo;

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
public class Evaluation implements Serializable {
    private static final long serialVersionUID = -7776698202322763502L;
    private Integer evaluation_id;
    private Integer user_id;
    private Integer goods_id;
    private String evaluation_detail;
    private Integer evaluation_star;
}