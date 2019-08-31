package com.xiaomi.pojo;

import java.io.Serializable;
import java.util.List;

//type还没有写
public class Type implements Serializable {
    private Integer type_id;
    private String goods_type;

    private List<Goods> goodsList;

    public Type() {
    }

    public Type(Integer type_id, String goods_type, List<Goods> goodsList) {
        this.type_id = type_id;
        this.goods_type = goods_type;
        this.goodsList = goodsList;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
