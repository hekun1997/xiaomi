package com.xiaomi.dao;

import com.xiaomi.pojo.Type;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author hekun
 */
@Mapper
public interface TypeMapper {
    @Select("select * from type")
    List<Type> getAllType();
    @Select("select * from type where typeId = #{id}")
    Type getTypeById(@Param("id")Integer id);

    @Select("SELECT * FROM `type` where typeId in(3,4,5,6,7,9,10,11,12)")
    @Results(value = {
            @Result(id = true,column = "typeId",property = "typeId"),
            @Result(column = "goodsType",property = "goodsType"),
            @Result(column = "typeId",property = "goodsList",
                    many = @Many(select = "com.xiaomi.dao.GoodsMapper.getGoodsByTypeId",fetchType = FetchType.EAGER))
    })
    List<Type> getTypeForIndex();

}
