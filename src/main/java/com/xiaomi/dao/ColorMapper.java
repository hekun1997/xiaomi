package com.xiaomi.dao;

import com.xiaomi.pojo.Color;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hekun
 */
@Mapper
public interface ColorMapper {
    @Select("select * from color where goods_id =#{goods_id}")
    List<Color> getColorsByGoodsId(@Param("goods_id")Integer goods_id);

    @Select("select * from color where color_id =#{color_id}")
    Color getColorsById(@Param("color_id")Integer color_id);
}
