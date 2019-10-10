package com.hwh.kfr.service;

import com.hwh.kfr.model.Order;

import java.util.List;

public interface IOrderService {

    /**
     * 挂单
     */
    int addOrder(Order order);

    /**
     * 撤单
     */
    int cancelOrder(Order order);

    /**
     * 确认订单
     */
    int completeOrder(Order order);


    /**
     * 投诉订单
     * @param order
     * @return
     */
    int complaintOrder(Order order);


    /**
     * 查询所有订单
     * @return
     */
    List<Order> findAllOrder();

    /**
     * 根据指定手机号查询订单 买单和卖单
     * @return
     */
    Order findOrderByPhone(String phone);

    /**
     * 根据订单号查询订单
     */

    Order findOrderById(String order_id);


}
