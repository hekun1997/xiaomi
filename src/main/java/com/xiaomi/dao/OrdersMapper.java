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
            @Result(column = "trading_flow", property = "trading_flow"),
            @Result(column = "goods_id", property = "goods_id"),
            @Result(column = "goods_version", property = "goods_version"),
            @Result(column = "goods_color_id", property = "goods_color_id"),
            @Result(column = "user_id", property = "user_id"),
            @Result(column = "time", property = "time"),
            @Result(column = "goods_count", property = "goods_count"),
            @Result(column = "goods_price", property = "goods_price"),
            @Result(column = "note", property = "note"),
            @Result(column = "status", property = "status"),
            @Result(column = "goods_version", property = "goodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getVersionById", fetchType = FetchType.EAGER))
    })
    Orders getOrderById(@Param("id")Integer id);

    @Select("select * from orders where user_id = #{user_id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "trading_flow",property = "trading_flow"),
            @Result(column = "goods_id",property = "goods_id"),
            @Result(column = "goods_version",property = "goods_version"),
            @Result(column = "goods_color_id",property = "goods_color_id"),
            @Result(column = "user_id",property = "user_id"),
            @Result(column = "time",property = "time"),
            @Result(column = "goods_count",property = "goods_count"),
            @Result(column = "goods_price",property = "goods_price"),
            @Result(column = "note",property = "note"),
            @Result(column = "status",property = "status"),
            @Result(column = "goods_id",property = "goods",
                    one = @One(select = "com.xiaomi.dao.GoodsMapper.getGoodsById",fetchType = FetchType.EAGER))

    })
    List<Orders> getOrderByUserId(@Param("user_id")Integer userId);

    @Delete("delete orders from where id =#{id}")
    Integer delOrdersById(@Param("id")Integer id);

    @Update("update orders set where id = #{id}")
    Integer updateOrdersById(@Param("id")Integer id);

    @Insert("insert into orders (goods_id, goods_version, goods_color_id, user_id, time,trading_flow,goods_count,goods_price,note,status) " +
            "values (#{goods_id},#{goods_version},#{goods_color_id},#{user_id},#{time},#{trading_flow},#{goods_count},#{goods_price},#{note},#{status})")
    Integer postOrders(Orders orders);

    @Select("select * from orders where status = 0 and user_id = #{user_id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "trading_flow",property = "trading_flow"),
            @Result(column = "goods_id",property = "goods_id"),
            @Result(column = "goods_version",property = "goods_version"),
            @Result(column = "goods_color_id",property = "goods_color_id"),
            @Result(column = "user_id",property = "user_id"),
            @Result(column = "time",property = "time"),
            @Result(column = "goods_count",property = "goods_count"),
            @Result(column = "goods_price",property = "goods_price"),
            @Result(column = "note",property = "note"),
            @Result(column = "status",property = "status"),
            @Result(column = "goods_id",property = "goods",
                    one = @One(select = "com.xiaomi.dao.GoodsMapper.getGoodsById",fetchType = FetchType.EAGER)),
            @Result(column = "goods_version",property = "goodsVersion",
                    one = @One(select = "com.xiaomi.dao.GoodsVersionMapper.getVersionById",fetchType = FetchType.EAGER)),
            @Result(column = "goods_color_id",property = "color",
            one = @One(select = "com.xiaomi.dao.ColorMapper.getColorsById",fetchType = FetchType.EAGER))

    })
    List<Orders> getTempOrdersByUserId(@Param("user_id")Integer userId);

    //购买时调用的sql语句
    @Update("update orders set goods_count=#{goods_count},goods_price=#{goods_price},status='1' where id =#{id}")
    Integer buyTempOrdersById(@Param("id")Integer id, @Param("goods_count") Integer goods_count, @Param("goods_price")BigDecimal goods_price);
}
