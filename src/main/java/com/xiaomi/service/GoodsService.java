package com.xiaomi.service;

import com.xiaomi.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();

    Goods getGoodsById(Integer id);

    List<Goods> getGoodsByTypeId(Integer type_id);

    List<Goods> getGoodsByName(String goods_name);
}
