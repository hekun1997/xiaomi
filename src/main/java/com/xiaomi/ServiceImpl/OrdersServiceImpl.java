package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.GoodsVersionMapper;
import com.xiaomi.dao.OrdersMapper;
import com.xiaomi.pojo.GoodsVersion;
import com.xiaomi.pojo.Orders;
import com.xiaomi.service.GoodsVersionService;
import com.xiaomi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper = null;
    @Autowired
    GoodsVersionService goodsVersionService = null;

    @Override
    public List<Orders> getAllOrders() {
        return ordersMapper.getAllOrders();
    }

    @Override
    public Orders getOrderById(Integer id) {
        return ordersMapper.getOrderById(id);
    }

    @Override
    public List<Orders> getOrderByUserId(Integer userId) {
        return ordersMapper.getOrderByUserId(userId);
    }

    @Override
    public Integer delOrdersById(Integer id) {
        return ordersMapper.delOrdersById(id);
    }

    @Override
    public Integer updateOrdersById(Integer id) {
        return ordersMapper.updateOrdersById(id);
    }

    @Override
    public Integer postOrders(Orders orders) {
        return ordersMapper.postOrders(orders);
    }

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
        GoodsVersion goodsVersion = goodsVersionService.getVersionById(orders.getGoods_version());
        if(count <= goodsVersion.getGoods_count()){
            Integer newGoodsCount = goodsVersion.getGoods_count() - count;
            goodsVersionService.updateVersionById(goodsVersion.getVersion_id(),newGoodsCount);
            BigDecimal singlePrice = goodsVersion.getGoods_price();
            BigDecimal resultPrice = singlePrice.multiply(new BigDecimal(count.doubleValue()));//goodsVersion.getGoods_price() * BigDecimal.valueOf((long)count);
            ordersMapper.buyTempOrdersById(orders.getId(),count,resultPrice);
        }
        return null;
    }
}
