package com.hwh.kfr.model;

import java.io.Serializable;


/**
 * @description 主要账户数据类
 *
 */
public class MainData implements Serializable {

    //可售额度 availableQuota;
    //可售余额 availableBalance;
    //矿池资产 pool;
    private Integer mid;
    private Double availableQuota;
    private Double availableBalance;
    private Double pool;
    private Integer uid;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Double getAvailableQuota() {
        return availableQuota;
    }

    public void setAvailableQuota(Double availableQuota) {
        this.availableQuota = availableQuota;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Double getPool() {
        return pool;
    }

    public void setPool(Double pool) {
        this.pool = pool;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "MainData{" +
                "mid=" + mid +
                ", availableQuota=" + availableQuota +
                ", availableBalance=" + availableBalance +
                ", pool=" + pool +
                ", uid=" + uid +
                '}';
    }
}

