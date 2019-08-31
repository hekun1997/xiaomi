package com.xiaomi.dao;

import com.xiaomi.pojo.GoodsImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper {
    @Select("select * from goods_image")
    List<GoodsImage> getAllImage();

    @Select("select * from goods_image where goods_id = #{goods_id}")
    GoodsImage getImageByGoodsId(@Param("goods_id")Integer goods_id);
}
