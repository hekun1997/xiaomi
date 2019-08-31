package com.xiaomi.pojo;

import java.io.Serializable;

public class OrdersBody implements Serializable {
    private Integer ordersId;
    private Integer count;

    public OrdersBody() {
    }

    public OrdersBody(Integer ordersId, Integer count) {
        this.ordersId = ordersId;
        this.count = count;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
