package com.hwh.kfr.service.impl;

import com.hwh.kfr.dao.IOrderDao;
import com.hwh.kfr.model.Order;
import com.hwh.kfr.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    @Transactional
    public int addOrder(Order order) {
        int i = orderDao.insertOrder(order);
        return i;
    }

    @Override
    @Transactional
    public int cancelOrder(Order order) {
        int i = orderDao.deleteOrder(order);
        return i;
    }

    @Override
    @Transactional
    public int completeOrder(Order order) {
        //完成订单改变订单状态为 1
        order.setOrder_status(1);
        int i = orderDao.updateOrder(order);
        return i;
    }

    @Override
    public int complaintOrder(Order order) {
        return 0;
    }

    @Override
    public List<Order> findAllOrder() {
        return null;
    }

    @Override
    public Order findOrderByPhone(String phone) {
        return null;
    }

    @Override
    public Order findOrderById(String order_id) {
        Order order = orderDao.findOrderById(order_id);
        return order;
    }
}
