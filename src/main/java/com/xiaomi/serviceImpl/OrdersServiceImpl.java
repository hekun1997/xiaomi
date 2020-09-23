package com.xiaomi.serviceImpl;

import com.xiaomi.dao.OrdersMapper;
import com.xiaomi.pojo.GoodsVersion;
import com.xiaomi.pojo.Orders;
import com.xiaomi.service.GoodsVersionService;
import com.xiaomi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@CacheConfig(cacheNames = "orders", cacheManager = "cacheManager")
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private GoodsVersionService goodsVersionService;

    @Cacheable(key = "'getAllOrders'")
    @Override
    public List<Orders> getAllOrders() {
        return ordersMapper.getAllOrders();
    }

    @Cacheable(key = "'getOrderById' + #id")
    @Override
    public Orders getOrderById(Integer id) {
        return ordersMapper.getOrderById(id);
    }

    @Cacheable(key = "'getOrderByUserId' + #userId")
    @Override
    public List<Orders> getOrderByUserId(Integer userId) {
        return ordersMapper.getOrderByUserId(userId);
    }

    @CacheEvict(key = "'getOrderById' + #id")
    @Override
    public Integer delOrdersById(Integer id) {
        return ordersMapper.delOrdersById(id);
    }

    @CachePut(key = "'getOrderById' + #id")
    @Override
    public Integer updateOrdersById(Integer id) {
        return ordersMapper.updateOrdersById(id);
    }

    @CachePut(key = "'getOrderById' + #id")
    @Override
    public Integer postOrders(Orders orders) {
        return ordersMapper.postOrders(orders);
    }

    @Cacheable(key = "'getTempOrdersByUserId' + #userId")
    @Override
    public List<Orders> getTempOrdersByUserId(Integer userId) {
        return ordersMapper.getTempOrdersByUserId(userId);
    }

    /**
     *隔离级别为Isolation.REPEATABLE_READ 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生。
     * 如果当前存在事务则,则挂起,如果不存在,则创建
     * @param id
     * @param count
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRES_NEW)
    @Override
    public Integer updateOrdersByIdAndGoodsCount(Integer id, Integer count) {
        Orders orders = ordersMapper.getOrderById(id);
        GoodsVersion goodsVersion = goodsVersionService.getVersionById(orders.getVersion());
        if(count <= goodsVersion.getGoodsCount()){
            Integer newGoodsCount = goodsVersion.getGoodsCount() - count;
            goodsVersionService.updateVersionById(goodsVersion.getVersionId(),newGoodsCount);
            BigDecimal singlePrice = goodsVersion.getGoodsPrice();

            BigDecimal resultPrice = singlePrice.multiply(new BigDecimal(count.doubleValue()));
            ordersMapper.buyTempOrdersById(orders.getId(),count,resultPrice);
        }
        return null;
    }
}
