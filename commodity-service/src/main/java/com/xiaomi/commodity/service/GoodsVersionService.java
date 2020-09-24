package com.xiaomi.commodity.service;

import com.xiaomi.pojo.GoodsVersion;

import java.util.List;

public interface GoodsVersionService {
    List<GoodsVersion> getVersionByGoodsId(Integer goods_id);

    GoodsVersion getLowestVersionByGoodsSId(Integer goods_id);

    GoodsVersion getVersionById(Integer version_id);

    Integer updateVersionById(Integer version_id, Integer goods_count);
}
