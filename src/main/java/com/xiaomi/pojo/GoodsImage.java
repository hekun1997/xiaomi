package com.xiaomi.pojo;

import java.io.Serializable;

public class GoodsImage implements Serializable {
    private Integer id;
    private Integer goods_id;
    private String small_src;
    private String middel_src;
    private String large_src;

    public GoodsImage() {
    }

    public GoodsImage(Integer id, Integer goods_id, String small_src, String middel_src, String large_src) {
        this.id = id;
        this.goods_id = goods_id;
        this.small_src = small_src;
        this.middel_src = middel_src;
        this.large_src = large_src;
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

    public String getSmall_src() {
        return small_src;
    }

    public void setSmall_src(String small_src) {
        this.small_src = small_src;
    }

    public String getMiddel_src() {
        return middel_src;
    }

    public void setMiddel_src(String middel_src) {
        this.middel_src = middel_src;
    }

    public String getLarge_src() {
        return large_src;
    }

    public void setLarge_src(String large_src) {
        this.large_src = large_src;
    }
}
