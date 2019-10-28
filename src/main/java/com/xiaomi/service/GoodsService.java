package com.xiaomi.service;

import com.github.pagehelper.Page;
import com.xiaomi.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();

    Goods getGoodsById(Integer id);

    List<Goods> getGoodsByTypeId(Integer type_id);

    List<Goods> getGoodsByName(String goods_name);

    Page<Goods> getGoodsByName2(String goods_name);
}
