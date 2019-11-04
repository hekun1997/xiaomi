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

@CacheConfig(cacheNames = "goods", cacheManager = "cacheManager")
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Cacheable(key = "'getAllGoods'")
    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Cacheable(key = "'getGoodsById'+#id")
    @Override
    public Goods getGoodsById(Integer id) {
        return goodsMapper.getGoodsById(id);
    }

    @Cacheable(key = "'getGoodsByTypeId' + #type_id")
    @Override
    public List<Goods> getGoodsByTypeId(Integer type_id) {
        return goodsMapper.getGoodsByTypeId(type_id);
    }

    @Cacheable(key = "'getGoodsByName' + #goods_name")
    @Override
    public List<Goods> getGoodsByName(String goods_name) {
        return goodsMapper.getGoodsByName(goods_name);
    }
}
