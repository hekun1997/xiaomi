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
    @Select("select * from type where type_id = #{id}")
    Type getTypeById(@Param("id")Integer id);

    @Select("SELECT * FROM `type` where type_id in(3,4,5,6,7,9,10,11,12)")
    @Results(value = {
            @Result(id = true,column = "type_id",property = "type_id"),
            @Result(column = "goods_type",property = "goods_type"),
            @Result(column = "type_id",property = "goodsList",
                    many = @Many(select = "com.xiaomi.dao.GoodsMapper.getGoodsByTypeId",fetchType = FetchType.EAGER))
    })
    List<Type> getTypeForIndex();

}
