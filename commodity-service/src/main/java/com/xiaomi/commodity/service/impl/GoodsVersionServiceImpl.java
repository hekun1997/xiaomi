package com.xiaomi.commodity.service.impl;

import com.xiaomi.dao.GoodsVersionMapper;
import com.xiaomi.pojo.GoodsVersion;
import com.xiaomi.service.GoodsVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "goodsVersion", cacheManager = "cacheManager")
@Service
public class GoodsVersionServiceImpl implements GoodsVersionService {
    @Autowired
    private GoodsVersionMapper goodsVersionMapper;

    @Cacheable(key = "'getVersionByGoodsId' + #goods_id")
    @Override
    public List<GoodsVersion> getVersionByGoodsId(Integer goods_id) {
        return goodsVersionMapper.getVersionByGoodsId(goods_id);
    }

    @Cacheable(key = "'getLowestVersionByGoodsSId' + #goods_id")
    @Override
    public GoodsVersion getLowestVersionByGoodsSId(Integer goods_id) {
        return goodsVersionMapper.getLowestVersionByGoodsSId(goods_id);
    }

    @Cacheable(key = "'getVersionById' + #version_id")
    @Override
    public GoodsVersion getVersionById(Integer version_id) {
        return goodsVersionMapper.getVersionById(version_id);
    }

    @CachePut(key = "'updateVersionById' + #version_id")
    @Override
    public Integer updateVersionById(Integer version_id,Integer goods_count) {
        return goodsVersionMapper.updateVersionById(version_id,goods_count);
    }
}
