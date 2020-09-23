package com.xiaomi.common.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author hekun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {
    private static final long serialVersionUID = 5067280241061126391L;
    private Integer id;
    /**
     * //18位交易流水号
     */
    private String trading_flow;
    private Integer goodsId;
    private Integer version;
    private Integer goodsColorId;
    private Integer userId;
    private Timestamp time;
    private Integer goodsCount;
    private BigDecimal goodsPrice;
    private String note;
    /**
     * 0为未购买 ,1为已购买
     */
    private Integer status;

    private Goods goods;

    private GoodsVersion goodsVersion;

    private Color color;

    public Orders(String trading_flow, Integer goodsId, Integer version, Integer goodsColorId, Integer userId, Timestamp time, Integer goodsCount, BigDecimal goodsPrice, String note, Integer status) {
        this.trading_flow = trading_flow;
        this.goodsId = goodsId;
        this.version = version;
        this.goodsColorId = goodsColorId;
        this.userId = userId;
        this.time = time;
        this.goodsCount = goodsCount;
        this.goodsPrice = goodsPrice;
        this.note = note;
        this.status = status;
    }

    public Orders(Integer id, String trading_flow, Integer goodsId, Integer version, Integer goodsColorId, Integer userId, Timestamp time, Integer goodsCount, BigDecimal goodsPrice, String note, Integer status, Goods goods) {
        this.id = id;
        this.trading_flow = trading_flow;
        this.goodsId = goodsId;
        this.version = version;
        this.goodsColorId = goodsColorId;
        this.userId = userId;
        this.time = time;
        this.goodsCount = goodsCount;
        this.goodsPrice = goodsPrice;
        this.note = note;
        this.status = status;
        this.goods = goods;
    }
}