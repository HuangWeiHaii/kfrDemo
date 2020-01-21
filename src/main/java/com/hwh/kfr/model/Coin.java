package com.hwh.kfr.model;


import java.io.Serializable;

/**
 *
 * @description 币类
 * @creat-date 2019年9月26日14:57:09
 */
public class Coin implements Serializable {
    private Integer cid;
    public static Double price;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "cid=" + cid +
                ", price=" + price +
                '}';
    }
}
