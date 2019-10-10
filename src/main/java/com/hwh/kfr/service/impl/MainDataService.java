package com.hwh.kfr.service.impl;

import com.hwh.kfr.dao.IMainDataDao;
import com.hwh.kfr.model.MainData;
import com.hwh.kfr.service.IMainDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MainDataService implements IMainDataService {

    @Autowired
    private IMainDataDao iMainDataDao;

    @Override
    public MainData selectAllDataById(Integer uid) {
        return iMainDataDao.selectAllDataById(uid);
    }


    //传入的是根据UID查询到的要签到的mainData
    @Override
    @Transactional
    public boolean release(MainData mainData) {

        try {

            Double pool = mainData.getPool();
            Double value = pool - (pool * mainData.getProportion());
            //扣除矿池千分之二
            mainData.setPool(value);
            //可售余额增加释放的值
            mainData.setAvailableBalance(mainData.getAvailableBalance() + (pool * mainData.getProportion()));
            //存入数据
            iMainDataDao.updateData(mainData);
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
