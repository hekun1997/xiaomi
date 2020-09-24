package com.xiaomi.commodity.dao;

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
    @Select("select * from color where goodsId =#{goodsId}")
    List<Color> getColorsByGoodsId(@Param("goodsId") Integer goodsId);

    @Select("select * from color where colorId =#{colorId}")
    Color getColorsById(@Param("colorId") Integer colorId);
}
