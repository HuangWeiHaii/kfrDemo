package com.hwh.kfr.service.impl;

import com.hwh.kfr.dao.IMainDataDao;
import com.hwh.kfr.dao.IUserDao;
import com.hwh.kfr.model.Inferior;
import com.hwh.kfr.model.User;
import com.hwh.kfr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IMainDataDao mainDataDao;

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    @Cacheable(cacheNames = "users")
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userDao.findUserByPhone(phone);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    //@Async("taskExecutor")
    public User login(String username,String password) {
        User user = userDao.findUserByUsernameAndPassword(username,password);
        if (user != null){
            List<Inferior> inferiorUsername = userDao.findInferiorUsername(user.getUsername());
            if (inferiorUsername != null && inferiorUsername.size() != 0) {
                user.setInferior(inferiorUsername);
            }
            return user;
        }
        return null;
    }

    @Override
    public List<Inferior> findInferiorByUsername(String username) {
        return userDao.findInferiorUsername(username);
    }

    @Override
    @Transactional
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<String, Object>();

        //判断用户名存在
        if (userDao.findUserByUsername(user.getUsername()) != null){
            map.put("msg","用户名已存在");
            map.put("status",false);
            return map;
        }
        //判断为空....

        //判断上级是否存在


        //成功
        userDao.addUser(user);
        User user2 = userDao.findUserByUsername(user.getUsername());

        //创建账户数据
        mainDataDao.addMainData(user2.getId());
        map.put("msg","注册成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public int authenticateUser(User user) {
        User u = userDao.findUserByUsername(user.getUsername());
        if (u == null){
            return 0;
        }
        u.setIdcard(user.getIdcard());
        u.setNikeName(user.getNikeName());
        u.setCertifiedStatus(1);
        int i = userDao.updateUser(u);
        return i;
    }


}
