package com.xiaomi.commodity.service;

import com.xiaomi.common.bo.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> getAllGoods();

    Goods getGoodsById(Integer id);

    List<Goods> getGoodsByTypeId(Integer type_id);

    List<Goods> getGoodsByName(String goods_name);

}
