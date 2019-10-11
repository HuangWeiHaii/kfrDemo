package com.hwh.kfr.dao;


import com.hwh.kfr.model.MainData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @project KFR
 * @author HWH
 * @date 2019年9月24日20:57:32
 * @description 数据访问-主要面板数据的操控
 * @version 1.0
 */

@Mapper
@Repository
public interface IMainDataDao {

    /**
     *
     * @return 根据用户ID返回一个指定用户的所有面板数据
     */
    MainData selectAllDataById(Integer uid);


    void updateData(MainData mainData);

    @Insert("insert into kfr_maindata(uid) values (#{uid})")
    int addMainData(Integer uid);


}
