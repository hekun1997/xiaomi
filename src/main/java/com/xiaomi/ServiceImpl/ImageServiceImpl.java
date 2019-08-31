package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.ImageMapper;
import com.xiaomi.pojo.GoodsImage;
import com.xiaomi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper = null;

    @Override
    public List<GoodsImage> getAllImage() {
        return imageMapper.getAllImage();
    }

    @Override
    public GoodsImage getImageByGoodsId(Integer goods_id) {
        return imageMapper.getImageByGoodsId(goods_id);
    }
}
