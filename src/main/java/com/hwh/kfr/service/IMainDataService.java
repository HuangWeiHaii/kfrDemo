package com.hwh.kfr.service;

import com.hwh.kfr.model.MainData;

public interface IMainDataService {

    /**
     *
     * @return 返回一个用户的所有面板数据
     */
    MainData selectAllDataById(Integer uid);

    /**
     * 每日释放矿池功能
     */
    boolean release(MainData mainData);

}
