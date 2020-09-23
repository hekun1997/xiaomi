package com.xiaomi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaomi.configuration.web.UserThread;
import com.xiaomi.pojo.Orders;
import com.xiaomi.pojo.OrdersBody;
import com.xiaomi.pojo.User;
import com.xiaomi.service.GoodsVersionService;
import com.xiaomi.service.OrdersService;
import com.xiaomi.tools.AliPayTools;
import com.xiaomi.tools.TradingFlowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

/**
 * @author hekun
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService = null;
    @Autowired
    GoodsVersionService goodsVersionService = null;

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public ModelAndView getOrdersById(@PathVariable("id")Integer id){
        Orders order = ordersService.getOrderById(id);
        return new ModelAndView("order_detail","order",order);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public ModelAndView getOrdersByUserId(@PathVariable("userId")Integer userId, HttpSession session){
        ModelAndView mv = new ModelAndView("dingdanzhongxin");
        List<Orders> orders = ordersService.getOrderByUserId(userId);
        User user = UserThread.get();
        mv.addObject("Orders",orders);
        mv.addObject("User",user);
        return mv;
    }

    /**
     * 加入购物车
     * @param params
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public String postOrders(@RequestParam Map<String,Object> params){

        Integer goods_id = Integer.valueOf((String)params.get("goods_id"));
        //user_id需要通过页面传递过来,ajax传递的user_id值还未增加
        Integer user_id = Integer.valueOf((String)params.get("user_id"));
        Integer goods_version = Integer.valueOf((String)params.get("goods_version"));
        Integer goods_color_id = Integer.valueOf((String)params.get("color_id"));
        //18位交易流水号
        String trading_flow = TradingFlowUtil.get();
        Integer goods_count = 0;
        BigDecimal goods_price = new BigDecimal(0.00);
        String note = "添加至购物车";
        //0为未支付 ,1为已购买
        Integer status = 0;
        Timestamp time = new Timestamp(System.currentTimeMillis());

        Orders orders = new Orders(trading_flow,goods_id,goods_version,goods_color_id,user_id,time,goods_count,goods_price,note,status);
        ordersService.postOrders(orders);
        return "添加购物车成功!";
    }

    @RequestMapping("/temp/{userId}")
    public ModelAndView tempOrders(@PathVariable("userId") Integer userId,HttpSession session){
        List<Orders> ordersList = ordersService.getTempOrdersByUserId(userId);
        User user = UserThread.get();
        ModelAndView mv = new ModelAndView("gouwuche");
        mv.addObject("ordersSize",ordersList.size());
        mv.addObject("ordersList",ordersList);
        mv.addObject("User",user);
        return mv;
    }

    @RequestMapping("/check")
    @ResponseBody
    public Integer checkOrders(@RequestParam Map<String,Object> params){
        Integer orderId = Integer.valueOf((String)params.get("orderId"));
        Integer count = Integer.valueOf((String)params.get("count"));
        Orders orders = ordersService.getOrderById(orderId);
        Integer maxCount = goodsVersionService.getVersionById(orders.getVersion()).getGoodsCount();
        if (count <= maxCount) {
            return -1;
        }
        return maxCount;
    }

    @RequestMapping("/buy")
    @ResponseBody
    public String buy(@RequestParam Map<String,Object> paramsBody){
        String requestStr = "";
        Integer goodsCount = 0;
        Integer userId = null;
        BigDecimal price = new BigDecimal("0.0");

        for (String key : paramsBody.keySet()) {
            requestStr += key;
        }

        JSONArray object = JSON.parseArray(requestStr);
        List<OrdersBody> paramsList = new ArrayList<>();

        for (Object obj : object){
            JSONObject jsonObject = JSON.parseObject(obj.toString());
            OrdersBody ordersBody = new OrdersBody();
            ordersBody.setOrdersId(jsonObject.getInteger("orderId"));
            ordersBody.setCount(jsonObject.getInteger("count"));
            paramsList.add(ordersBody);
        }

        for (OrdersBody ordersBody : paramsList){
            goodsCount += ordersBody.getCount();
            Orders orders = ordersService.getOrderById(ordersBody.getOrdersId());
            userId = orders.getId();
            BigDecimal tempPrice = new BigDecimal(ordersBody.getCount()).multiply(orders.getGoodsVersion().getGoodsPrice());
            price = price.add(tempPrice);
            ordersService.updateOrdersByIdAndGoodsCount(ordersBody.getOrdersId(),ordersBody.getCount());
        }

        String alipayResult = AliPayTools.pay(userId,"批量购买",goodsCount,Float.valueOf(price.toString()),TradingFlowUtil.get());

        return alipayResult;
    }
}
