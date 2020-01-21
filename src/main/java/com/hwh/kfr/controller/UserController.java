package com.hwh.kfr.controller;


import com.hwh.kfr.model.MainData;
import com.hwh.kfr.model.User;
import com.hwh.kfr.service.impl.MainDataService;
import com.hwh.kfr.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MainDataService mainDataService;

    @RequestMapping("/users")
    @ResponseBody
    public List<User> register(){
        return userService.findAllUser();
    }

    @PostMapping("/release")
    @ResponseBody
    public Map<String,Object> release(@RequestParam("id") Integer id){
        HashMap<String,Object> map = new HashMap<>();
        MainData mainData = userService.findUserById(id).getMainData();
        boolean release = mainDataService.release(mainData);
        if (release){
            map.put("msg","签到成功");
        }
        else {
            map.put("msg","签到失败");
        }
        return map;
    }

    @PostMapping("/register")
    @ResponseBody
    public Map<String,Object> register(User user){
        Map<String,Object> map = new HashMap<>();
        Map<String, Object> register = userService.register(user);
        boolean status = (boolean)register.get("status");
        if (status){
            map.put("msg","注册成功");
            return map;
        }
        map.put("msg","注册失败");
        return map;

    }

    @PostMapping("/authenticateUser")
    @ResponseBody
    public Map<String,Object> authenticateUser(User user){
        Map<String,Object> map = new HashMap<>();
        int i = userService.authenticateUser(user);
        if (i == 1){
            map.put("msg","认证成功");
            return map;
        }
        map.put("msg","认证失败");
        return map;

    }
}
