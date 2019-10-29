package com.xiaomi.ServiceImpl;

import com.github.pagehelper.Page;
import com.xiaomi.dao.GoodsMapper;
import com.xiaomi.pojo.Goods;
import com.xiaomi.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsMapper.getGoodsById(id);
    }

    @Override
    public List<Goods> getGoodsByTypeId(Integer type_id) {
        return goodsMapper.getGoodsByTypeId(type_id);
    }

    @Override
    public List<Goods> getGoodsByName(String goods_name) {
        return goodsMapper.getGoodsByName(goods_name);
    }
}
