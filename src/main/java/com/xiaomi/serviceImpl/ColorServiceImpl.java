package com.xiaomi.serviceImpl;

import com.xiaomi.dao.ColorMapper;
import com.xiaomi.pojo.Color;
import com.xiaomi.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "colors", cacheManager = "cacheManager")
@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorMapper colorMapper;

    @Cacheable(key = "'getColorsByGoodsId'+#goods_id")
    @Override
    public List<Color> getColorsByGoodsId(Integer goods_id) {
        return colorMapper.getColorsByGoodsId(goods_id);
    }

    @Cacheable(key = "'getColorsById'+#color_id")
    @Override
    public Color getColorsById(Integer color_id) {
        return colorMapper.getColorsById(color_id);
    }
}
