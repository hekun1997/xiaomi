package com.xiaomi.pojo;

import java.io.Serializable;

public class Color implements Serializable {
    private Integer color_id;
    private Integer goods_id;
    private String color_name;
    private String rgb;//7位 #开头

    public Color(Integer color_id, Integer goods_id, String color_name, String rgb) {
        this.color_id = color_id;
        this.goods_id = goods_id;
        this.color_name = color_name;
        this.rgb = rgb;
    }

    public Color() {
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }
}
