package com.xiaomi.order.repository;

import com.xiaomi.order.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
