package com.xiaomi.order.service;

import com.xiaomi.common.bo.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> getAllOrders();

    Orders getOrderById(Integer id);

    List<Orders> getOrderByUserId(Integer userId);

    Integer delOrdersById(Integer id);

    Integer updateOrdersById(Integer id);

    Integer postOrders(Orders orders);

    List<Orders> getTempOrdersByUserId(Integer userId);

    Integer updateOrdersByIdAndGoodsCount(Integer id, Integer count);
}