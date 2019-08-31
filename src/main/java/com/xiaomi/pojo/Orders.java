package com.xiaomi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Orders implements Serializable {
    private Integer id; //订单号
    private String trading_flow;//18位交易流水号
    private Integer goods_id;
    private Integer goods_version;
    private Integer goods_color_id;
    private Integer user_id;
    private Timestamp time;
    private Integer goods_count;
    private BigDecimal goods_price;
    private String note;
    private Integer status; //0为未购买 ,1为已购买

    private Goods goods;

    private GoodsVersion goodsVersion;

    private Color color;

    public Orders() {
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTrading_flow() {
        return trading_flow;
    }

    public void setTrading_flow(String trading_flow) {
        this.trading_flow = trading_flow;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public BigDecimal getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(BigDecimal goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_version() {
        return goods_version;
    }

    public void setGoods_version(Integer goods_version) {
        this.goods_version = goods_version;
    }

    public Integer getGoods_color_id() {
        return goods_color_id;
    }

    public void setGoods_color_id(Integer goods_color_id) {
        this.goods_color_id = goods_color_id;
    }

    public GoodsVersion getGoodsVersion() {
        return goodsVersion;
    }

    public void setGoodsVersion(GoodsVersion goodsVersion) {
        this.goodsVersion = goodsVersion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}