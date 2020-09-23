package com.xiaomi.dao;

import com.xiaomi.pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> getAllGoods();

    @Select("select * from goods where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "goods_name",property = "goods_name"),
            @Result(column = "goods_description",property = "goods_description"),
            @Result(column = "type_id",property = "type_id"),
            @Result(column = "id",property = "goodsImage",
                    one = @One(select = "com.xiaomi.dao.ImageMapper.getImageByGoodsId",fetchType = FetchType.LAZY)),
            @Result(column = "id",property = "goodsVersion",
                    many = @Many(select = "com.xiaomi.dao.GoodsVersionMapper.getVersionByGoodsId",fetchType = FetchType.LAZY)),
            @Result(column = "id",property = "goodsColors",
                    many = @Many(select = "com.xiaomi.dao.ColorMapper.getColorsByGoodsId",fetchType = FetchType.LAZY))
    })
    Goods getGoodsById(@Param("id") Integer id);

    @Select("select * from goods where type_id =#{type_id}")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "goods_name",property = "goods_name"),
            @Result(column = "goods_description",property = "goods_description"),
            @Result(column = "type_id",property = "type_id"),
            @Result(column = "id",property = "goodsImage",
                    one = @One(select = "com.xiaomi.dao.ImageMapper.getImageByGoodsId",fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "lowestGoodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getLowestVersionByGoodsSId",fetchType = FetchType.EAGER)),
    })
    List<Goods> getGoodsByTypeId(@Param("type_id")Integer type_id);

    @Select("select * from goods where goods_name like concat('%',#{goods_name},'%')")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "goods_name",property = "goods_name"),
            @Result(column = "goods_description",property = "goods_description"),
            @Result(column = "type_id",property = "type_id"),
            @Result(column = "id",property = "goodsImage",
                    one = @One(select = "com.xiaomi.dao.ImageMapper.getImageByGoodsId",fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "lowestGoodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getLowestVersionByGoodsSId",fetchType = FetchType.EAGER)),
    })
    List<Goods> getGoodsByName(@Param("goods_name")String goods_name);

}
