package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.GoodsVersionMapper;
import com.xiaomi.pojo.GoodsVersion;
import com.xiaomi.service.GoodsVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsVersionServiceImpl implements GoodsVersionService {
    @Autowired
    GoodsVersionMapper goodsVersionMapper = null;

    @Override
    public List<GoodsVersion> getVersionByGoodsId(Integer goods_id) {
        return goodsVersionMapper.getVersionByGoodsId(goods_id);
    }

    @Override
    public GoodsVersion getLowestVersionByGoodsSId(Integer goods_id) {
        return goodsVersionMapper.getLowestVersionByGoodsSId(goods_id);
    }

    @Override
    public GoodsVersion getVersionById(Integer version_id) {
        return goodsVersionMapper.getVersionById(version_id);
    }

    @Override
    public Integer updateVersionById(Integer version_id,Integer goods_count) {
        return goodsVersionMapper.updateVersionById(version_id,goods_count);
    }
}
