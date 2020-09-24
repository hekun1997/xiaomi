package com.xiaomi.commodity.service;

import com.xiaomi.pojo.GoodsImage;

import java.util.List;

public interface ImageService {

    List<GoodsImage> getAllImage();

    GoodsImage getImageByGoodsId(Integer goods_id);
}
