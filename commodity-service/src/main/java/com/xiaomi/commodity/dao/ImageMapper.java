package com.xiaomi.commodity.dao;

import com.xiaomi.pojo.GoodsImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hekun
 */
@Mapper
public interface ImageMapper {
    @Select("select * from goodsImage")
    List<GoodsImage> getAllImage();

    @Select("select * from goodsImage where goodsId = #{goodsId}")
    GoodsImage getImageByGoodsId(@Param("goodsId") Integer goodsId);
}
