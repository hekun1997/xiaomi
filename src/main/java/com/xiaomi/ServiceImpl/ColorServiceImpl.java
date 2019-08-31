package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.ColorMapper;
import com.xiaomi.pojo.Color;
import com.xiaomi.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorMapper colorMapper = null;

    @Override
    public List<Color> getColorsByGoodsId(Integer goods_id) {
        return colorMapper.getColorsByGoodsId(goods_id);
    }

    @Override
    public Color getColorsById(Integer color_id) {
        return colorMapper.getColorsById(color_id);
    }
}
