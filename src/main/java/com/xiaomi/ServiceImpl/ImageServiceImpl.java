package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.ImageMapper;
import com.xiaomi.pojo.GoodsImage;
import com.xiaomi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "images", cacheManager = "cacheManager")
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper;

    @Cacheable(key = "'getAllImage'")
    @Override
    public List<GoodsImage> getAllImage() {
        return imageMapper.getAllImage();
    }

    @Cacheable(key = "'getImageByGoodsId' + #goods_id")
    @Override
    public GoodsImage getImageByGoodsId(Integer goods_id) {
        return imageMapper.getImageByGoodsId(goods_id);
    }
}
