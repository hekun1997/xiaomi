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
    private Integer goodsId;
    private String smallSrc;
    private String middelSrc;
    private String largeSrc;
}
