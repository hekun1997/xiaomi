package com.xiaomi.common.bo;

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
    private Integer versionId;
    private Integer goodsId;
    private BigDecimal goodsPrice;
    private Integer goodsCount;
    private String goodsDetail;
    private Integer status;
}
