package com.xiaomi.order.repository;

import com.xiaomi.order.entity.OrdersItem;
import org.springframework.data.repository.CrudRepository;

/**
 * @author hekun
 */
public interface OrdersItemRepository extends CrudRepository<OrdersItem, Integer> {
}
