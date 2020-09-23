package com.xiaomi.dao;

import com.xiaomi.pojo.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hekun
 */
@Mapper
public interface OrdersMapper {
    @Select("select * from orders")
    List<Orders> getAllOrders();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "tradingFlow", property = "tradingFlow"),
            @Result(column = "goodsId", property = "goodsId"),
            @Result(column = "goodsVersion", property = "goodsVersion"),
            @Result(column = "goodsColorId", property = "goodsColorId"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "time", property = "time"),
            @Result(column = "goodsCount", property = "goodsCount"),
            @Result(column = "goodsPrice", property = "goodsPrice"),
            @Result(column = "note", property = "note"),
            @Result(column = "status", property = "status"),
            @Result(column = "goodsVersion", property = "goodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getVersionById", fetchType = FetchType.EAGER))
    })
    Orders getOrderById(@Param("id")Integer id);

    @Select("select * from orders where userId = #{userId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "tradingFlow",property = "tradingFlow"),
            @Result(column = "goodsId",property = "goodsId"),
            @Result(column = "goodsVersion",property = "goodsVersion"),
            @Result(column = "goodsColorId",property = "goodsColorId"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "time",property = "time"),
            @Result(column = "goodsCount",property = "goodsCount"),
            @Result(column = "goodsPrice",property = "goodsPrice"),
            @Result(column = "note",property = "note"),
            @Result(column = "status",property = "status"),
            @Result(column = "goodsId",property = "goods",
                    one = @One(select = "com.xiaomi.dao.GoodsMapper.getGoodsById",fetchType = FetchType.EAGER))

    })
    List<Orders> getOrderByUserId(@Param("userId")Integer userId);

    @Delete("delete orders from where id =#{id}")
    Integer delOrdersById(@Param("id")Integer id);

    @Update("update orders set where id = #{id}")
    Integer updateOrdersById(@Param("id")Integer id);

    @Insert("insert into orders (goodsId, goodsVersion, goodsColorId, userId, time,tradingFlow,goodsCount,goodsPrice,note,status) " +
            "values (#{goodsId},#{goodsVersion},#{goodsColorId},#{userId},#{time},#{tradingFlow},#{goodsCount},#{goodsPrice},#{note},#{status})")
    Integer postOrders(Orders orders);

    @Select("select * from orders where status = 0 and userId = #{userId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "tradingFlow",property = "tradingFlow"),
            @Result(column = "goodsId",property = "goodsId"),
            @Result(column = "goodsVersion",property = "goodsVersion"),
            @Result(column = "goodsColorId",property = "goodsColorId"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "time",property = "time"),
            @Result(column = "goodsCount",property = "goodsCount"),
            @Result(column = "goodsPrice",property = "goodsPrice"),
            @Result(column = "note",property = "note"),
            @Result(column = "status",property = "status"),
            @Result(column = "goodsId",property = "goods",
                    one = @One(select = "com.xiaomi.dao.GoodsMapper.getGoodsById",fetchType = FetchType.EAGER)),
            @Result(column = "goodsVersion",property = "goodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getVersionById",fetchType = FetchType.EAGER)),
            @Result(column = "goodsColorId",property = "color",
            one = @One(select = "com.xiaomi.dao.ColorMapper.getColorsById",fetchType = FetchType.EAGER))

    })
    List<Orders> getTempOrdersByUserId(@Param("userId")Integer userId);
    
    @Update("update orders set goodsCount=#{goodsCount},goodsPrice=#{goodsPrice},status='1' where id =#{id}")
    Integer buyTempOrdersById(@Param("id")Integer id, @Param("goodsCount") Integer goodsCount, @Param("goodsPrice")BigDecimal goodsPrice);
}
