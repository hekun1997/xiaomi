package com.xiaomi.dao;

import com.xiaomi.pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author hekun
 */
@Mapper
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> getAllGoods();

    @Select("select * from goods where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "goodsName",property = "goodsName"),
            @Result(column = "goodsDescription",property = "goodsDescription"),
            @Result(column = "typeId",property = "typeId"),
            @Result(column = "id",property = "goodsImage",
                    one = @One(select = "com.xiaomi.dao.ImageMapper.getImageByGoodsId",fetchType = FetchType.LAZY)),
            @Result(column = "id",property = "goodsVersion",
                    many = @Many(select = "com.xiaomi.dao.GoodsVersionMapper.getVersionByGoodsId",fetchType = FetchType.LAZY)),
            @Result(column = "id",property = "goodsColors",
                    many = @Many(select = "com.xiaomi.dao.ColorMapper.getColorsByGoodsId",fetchType = FetchType.LAZY))
    })
    Goods getGoodsById(@Param("id") Integer id);

    @Select("select * from goods where typeId =#{typeId}")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "goodsName",property = "goodsName"),
            @Result(column = "goodsDescription",property = "goodsDescription"),
            @Result(column = "typeId",property = "typeId"),
            @Result(column = "id",property = "goodsImage",
                    one = @One(select = "com.xiaomi.dao.ImageMapper.getImageByGoodsId",fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "lowestGoodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getLowestVersionByGoodsSId",fetchType = FetchType.EAGER)),
    })
    List<Goods> getGoodsByTypeId(@Param("typeId")Integer typeId);

    @Select("select * from goods where goodsName like concat('%',#{goodsName},'%')")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "goodsName",property = "goodsName"),
            @Result(column = "goodsDescription",property = "goodsDescription"),
            @Result(column = "typeId",property = "typeId"),
            @Result(column = "id",property = "goodsImage",
                    one = @One(select = "com.xiaomi.dao.ImageMapper.getImageByGoodsId",fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "lowestGoodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getLowestVersionByGoodsSId",fetchType = FetchType.EAGER)),
    })
    List<Goods> getGoodsByName(@Param("goodsName")String goodsName);

}
