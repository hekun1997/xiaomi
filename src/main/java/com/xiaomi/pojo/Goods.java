package com.xiaomi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author hekun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    private static final long serialVersionUID = 3058228855624450997L;
    private Integer id;
    private String goods_name;
    private String goods_description;
    private Integer type_id;

    private GoodsImage goodsImage;

    private List<GoodsVersion> goodsVersion;

    private GoodsVersion lowestGoodsVersion;

    private List<Color> goodsColors;

    public Goods(Integer id, String goods_name, String goods_description, Integer type_id, GoodsImage goodsImage, GoodsVersion lowestGoodsVersion) {
        this.id = id;
        this.goods_name = goods_name;
        this.goods_description = goods_description;
        this.type_id = type_id;
        this.goodsImage = goodsImage;
        this.lowestGoodsVersion = lowestGoodsVersion;
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

}