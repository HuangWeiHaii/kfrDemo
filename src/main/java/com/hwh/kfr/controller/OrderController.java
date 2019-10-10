package com.hwh.kfr.controller;

import com.hwh.kfr.model.Order;
import com.hwh.kfr.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @date 2019年10月2日03:17:15
     * @param order
     * @return
     */
    @PostMapping("addOrder")
    @ResponseBody
    public Map<String,Object> addOrder(Order order){
        Map<String,Object> map = new HashMap<>();

        //
        if (order.getCoin_number() == null){
            map.put("msg","请输入挂单数量");
            return map;
        }

        //生成一个OrderId;
        UUID uuid = UUID.randomUUID();
        order.setOrder_id(uuid.toString().substring(0,8));
        //设置order属性
        order.setTotalPrice(order.getPrice() * order.getCoin_number());
        int i = orderService.addOrder(order);
        if (i==1){
            map.put("msg","挂单成功");
        }
        else {
            map.put("msg","挂单失败");
        }
        return map;
    }

    /**
     * @date 2019年10月2日03:16:59
     * @param order_id
     * @return
     */
    @PostMapping("/completeOrder")
    @ResponseBody
    public Map<String,Object> completeOrder(@RequestParam("id") String order_id){
        Map<String,Object> map = new HashMap<>();
        //传进来一个订单ID,根据订单ID完成订单
        Order order = orderService.findOrderById(order_id);
        if (order == null){
            map.put("msg","没有此订单");
            return map;
        }
        int i = orderService.completeOrder(order);
        if (i == 1){
            map.put("msg","订单完成");
        }else {
            map.put("msg","订单完成失败");
        }
        return map;
    }
}
