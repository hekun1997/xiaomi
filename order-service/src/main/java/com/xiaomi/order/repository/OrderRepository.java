package com.xiaomi.order.repository;

import com.xiaomi.order.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
}
