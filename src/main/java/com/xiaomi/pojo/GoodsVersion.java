package com.xiaomi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsVersion implements Serializable {
    private Integer version_id;
    private Integer goods_id;
    private BigDecimal goods_price;
    private Integer goods_count;
    private String goods_detail;
    private Integer status;

    public GoodsVersion() {
    }

    public GoodsVersion(Integer version_id, Integer goods_id, BigDecimal goods_price, Integer goods_count, String goods_detail, Integer status) {
        this.version_id = version_id;
        this.goods_id = goods_id;
        this.goods_price = goods_price;
        this.goods_count = goods_count;
        this.goods_detail = goods_detail;
        this.status = status;
    }

    public Integer getVersion_id() {
        return version_id;
    }

    public void setVersion_id(Integer version_id) {
        this.version_id = version_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public BigDecimal getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(BigDecimal goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
