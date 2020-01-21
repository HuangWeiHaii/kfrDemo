package com.hwh.kfr.service;

import com.hwh.kfr.model.Inferior;
import com.hwh.kfr.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {


    /**
     * 查找所有用户
     */

    List<User> findAllUser();

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
     * 根据指定用户名查找用户信息
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 登陆功能
     * @param username 用户名
     * @return true-登陆成功 false-登陆失败
     */
    User login(String username,String password);

    /**
     * 查询指定用户名的信息以及其所有下级
     */
    List<Inferior> findInferiorByUsername(String username);

    /**
     * 注册功能
     */
    Map<String,Object> register(User user);

    /**
     * @Date 2019年10月2日16:08:05
     * @author HWH
     * 认证功能
    */
    int authenticateUser(User user);





}
