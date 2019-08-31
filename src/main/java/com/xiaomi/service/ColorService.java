package com.xiaomi.service;

import com.xiaomi.pojo.Color;

import java.util.List;

public interface ColorService {

    List<Color> getColorsByGoodsId(Integer goods_id);

    Color getColorsById(Integer color_id);
}
