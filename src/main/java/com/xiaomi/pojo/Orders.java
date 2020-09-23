package com.xiaomi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

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
    private Integer goods_id;
    private Integer goods_version;
    private Integer goods_color_id;
    private Integer user_id;
    private Timestamp time;
    private Integer goods_count;
    private BigDecimal goods_price;
    private String note;
    /**
     * 0为未购买 ,1为已购买
     */
    private Integer status;

    private Goods goods;

    private GoodsVersion goodsVersion;

    private Color color;

    public Orders(String trading_flow, Integer goods_id, Integer goods_version, Integer goods_color_id, Integer user_id, Timestamp time, Integer goods_count, BigDecimal goods_price, String note, Integer status) {
        this.trading_flow = trading_flow;
        this.goods_id = goods_id;
        this.goods_version = goods_version;
        this.goods_color_id = goods_color_id;
        this.user_id = user_id;
        this.time = time;
        this.goods_count = goods_count;
        this.goods_price = goods_price;
        this.note = note;
        this.status = status;
    }

    public Orders(Integer id, String trading_flow, Integer goods_id, Integer goods_version, Integer goods_color_id, Integer user_id, Timestamp time, Integer goods_count, BigDecimal goods_price, String note, Integer status, Goods goods) {
        this.id = id;
        this.trading_flow = trading_flow;
        this.goods_id = goods_id;
        this.goods_version = goods_version;
        this.goods_color_id = goods_color_id;
        this.user_id = user_id;
        this.time = time;
        this.goods_count = goods_count;
        this.goods_price = goods_price;
        this.note = note;
        this.status = status;
        this.goods = goods;
    }
}