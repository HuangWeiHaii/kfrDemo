package com.hwh.kfr.model;


import java.io.Serializable;

/**
 * @creat-date 2019年9月26日14:49:17
 * @description交易市场的 订单类
 */
public class Order implements Serializable {

    private String order_id;
    private Integer coin_number;
    private Integer buyer_id;
    private Integer seller_id;
    private User buyer;
    private User seller;
    private Double totalPrice;
    private Double price;
    private Integer order_status;

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getCoin_number() {
        return coin_number;
    }

    public void setCoin_number(Integer coin_number) {
        this.coin_number = coin_number;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", coin_number=" + coin_number +
                ", buyer_id=" + buyer_id +
                ", seller_id=" + seller_id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", totalPrice=" + totalPrice +
                ", price=" + price +
                ", order_status=" + order_status +
                '}';
    }
}


