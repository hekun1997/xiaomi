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
public class GoodsImage implements Serializable {
    private static final long serialVersionUID = -7855981250527070515L;
    private Integer id;
    private Integer goods_id;
    private String small_src;
    private String middel_src;
    private String large_src;
}
