package com.xiaomi.dao;

import com.xiaomi.pojo.GoodsVersion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsVersionMapper {
    @Select("select * from goods_version where goods_id = #{goods_id}")
    List<GoodsVersion> getVersionByGoodsId(@Param("goods_id")Integer goods_id);

    @Select("select MIN(goods_price) as goods_price from goods_version where goods_id = #{goods_id}")
    GoodsVersion getLowestVersionByGoodsSId(@Param("goods_id")Integer goods_id);

    @Select("select * from goods_version where version_id = #{version_id}")
    GoodsVersion getVersionById(@Param("version_id")Integer version_id);

    @Update("update goods_version set goods_count = #{goods_count} where version_id = #{version_id}")
    Integer updateVersionById(@Param("version_id") Integer version_id,@Param("goods_count")Integer goods_count);
}
