package com.hwh.kfr.dao;


import com.hwh.kfr.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 订单接口
 * @creat-time 2019年9月26日15:03:59
 */

@Mapper
@Repository
public interface IOrderDao {

    /**
     * 查找所有订单
     */
    List<Order> findAllOrders();

    /**
     * 根据订单ID查询订单
     */
    @Select("select * from kfr_order where order_id = #{order_id}")
    Order findOrderById(String order_id);

    /**
     * 插入订单
     * @param order
     * @return
     */
    @Insert("insert into kfr_order(order_id,coin_number,totalPrice,buyer_id,seller_id,price) values (#{order_id},#{coin_number},#{totalPrice},#{buyer_id},#{seller_id},#{price})")
    int insertOrder(Order order);

    /**
     * 删除订单
     * @param order
     */
    @Delete("delete from kfr_order where order_id = #{order_id}")
    int deleteOrder(Order order);

    @Update("update kfr_order set order_status = #{order_status} where order_id = #{order_id}")
    int updateOrder(Order order);

}

