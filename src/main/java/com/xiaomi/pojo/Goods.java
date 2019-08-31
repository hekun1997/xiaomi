package com.xiaomi.pojo;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {
    private Integer id;
    private String goods_name;
    private String goods_description;
    private Integer type_id;

    private GoodsImage goodsImage;

    private List<GoodsVersion> goodsVersion;

    private GoodsVersion lowestGoodsVersion;

    private List<Color> goodsColors;

    public Goods() {
    }

    public Goods(Integer id, String goods_name, String goods_description, Integer type_id, GoodsImage goodsImage, GoodsVersion lowestGoodsVersion) {
        this.id = id;
        this.goods_name = goods_name;
        this.goods_description = goods_description;
        this.type_id = type_id;
        this.goodsImage = goodsImage;
        this.lowestGoodsVersion = lowestGoodsVersion;
    }

    public Goods(Integer id, String goods_name, String goods_description, Integer type_id, GoodsImage goodsImage, List<GoodsVersion> goodsVersion, GoodsVersion lowestGoodsVersion, List<Color> goodsColors) {
        this.id = id;
        this.goods_name = goods_name;
        this.goods_description = goods_description;
        this.type_id = type_id;
        this.goodsImage = goodsImage;
        this.goodsVersion = goodsVersion;
        this.lowestGoodsVersion = lowestGoodsVersion;
        this.goodsColors = goodsColors;
    }

    public Goods(Integer id, String goods_name, String goods_description, Integer type_id, GoodsImage goodsImage, List<GoodsVersion> goodsVersion, List<Color> goodsColors) {
        this.id = id;
        this.goods_name = goods_name;
        this.goods_description = goods_description;
        this.type_id = type_id;
        this.goodsImage = goodsImage;
        this.goodsVersion = goodsVersion;
        this.goodsColors = goodsColors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<GoodsVersion> getGoodsVersion() {
        return goodsVersion;
    }

    public void setGoodsVersion(List<GoodsVersion> goodsVersion) {
        this.goodsVersion = goodsVersion;
    }

    public GoodsImage getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(GoodsImage goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_description() {
        return goods_description;
    }

    public void setGoods_description(String goods_description) {
        this.goods_description = goods_description;
    }

    public List<Color> getGoodsColors() {
        return goodsColors;
    }

    public void setGoodsColors(List<Color> goodsColors) {
        this.goodsColors = goodsColors;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public GoodsVersion getLowestGoodsVersion() {
        return lowestGoodsVersion;
    }

    public void setLowestGoodsVersion(GoodsVersion lowestGoodsVersion) {
        this.lowestGoodsVersion = lowestGoodsVersion;
    }
}