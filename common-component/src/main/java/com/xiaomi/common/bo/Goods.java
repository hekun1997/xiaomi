package com.xiaomi.common.bo;

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
    private String goodsName;
    private String goodsDescription;
    private Integer typeId;

    private GoodsImage goodsImage;

    private List<GoodsVersion> goodsVersion;

    private GoodsVersion lowestGoodsVersion;

    private List<Color> goodsColors;

    public Goods(Integer id, String goodsName, String goodsDescription, Integer typeId, GoodsImage goodsImage, GoodsVersion lowestGoodsVersion) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsDescription = goodsDescription;
        this.typeId = typeId;
        this.goodsImage = goodsImage;
        this.lowestGoodsVersion = lowestGoodsVersion;
    }

    public Goods(Integer id, String goodsName, String goodsDescription, Integer typeId, GoodsImage goodsImage, List<GoodsVersion> goodsVersion, List<Color> goodsColors) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsDescription = goodsDescription;
        this.typeId = typeId;
        this.goodsImage = goodsImage;
        this.goodsVersion = goodsVersion;
        this.goodsColors = goodsColors;
    }

}