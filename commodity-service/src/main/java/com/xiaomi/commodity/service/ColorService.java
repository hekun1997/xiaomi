package com.xiaomi.commodity.service;

import com.xiaomi.common.bo.Color;

import java.util.List;

/**
 * @author hekun
 */
public interface ColorService {

    List<Color> getColorsByGoodsId(Integer goods_id);

    Color getColorsById(Integer color_id);
}
