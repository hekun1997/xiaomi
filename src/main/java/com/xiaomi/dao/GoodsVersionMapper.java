package com.xiaomi.dao;

import com.xiaomi.pojo.GoodsVersion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author hekun
 */
@Mapper
public interface GoodsVersionMapper {
    @Select("select * from goods_version where goodsId = #{goodsId}")
    List<GoodsVersion> getVersionByGoodsId(@Param("goodsId")Integer goodsId);

    @Select("select MIN(goods_price) as goods_price from goods_version where goodsId = #{goodsId}")
    GoodsVersion getLowestVersionByGoodsSId(@Param("goodsId")Integer goodsId);

    @Select("select * from goods_version where versionId = #{versionId}")
    GoodsVersion getVersionById(@Param("versionId")Integer versionId);

    @Update("update goods_version set goods_count = #{goods_count} where versionId = #{versionId}")
    Integer updateVersionById(@Param("versionId") Integer versionId,@Param("goods_count")Integer goods_count);
}
