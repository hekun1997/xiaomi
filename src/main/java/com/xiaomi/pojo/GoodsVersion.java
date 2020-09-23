package com.xiaomi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hekun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVersion implements Serializable {
    private static final long serialVersionUID = 3606068549749372703L;
    private Integer version_id;
    private Integer goods_id;
    private BigDecimal goods_price;
    private Integer goods_count;
    private String goods_detail;
    private Integer status;
}
