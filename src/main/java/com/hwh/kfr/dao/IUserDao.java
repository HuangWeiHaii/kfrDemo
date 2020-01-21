package com.hwh.kfr.dao;


import com.hwh.kfr.model.Inferior;
import com.hwh.kfr.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project KFR
 * @author HWH
 * @date 2019年9月25日13:49:48
 * @description 数据访问-用户资料数据的操控
 * @version 1.0
 */

@Mapper
@Repository
public interface IUserDao {


    /**
     * 根据指定ID查找用户
     * @return
     */
    User findUserById(Integer id);


    /**
     * 根据用户手机号码查找用户
     * @return
     */
    User findUserByPhone(String phone);

    /**
     * 根据指定账户名查找用户
     */
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username,String password);


    List<Inferior> findInferiorUsername(String username);

    int addUser(User user);

    /**
     * 查找所有用户
     */

    List<User> findAllUser();

    @Update("update kfr_user set nikeName = #{nikeName},idcard = #{idcard},certifiedStatus = #{certifiedStatus} where username = #{username}")
    int updateUser(User user);


}
