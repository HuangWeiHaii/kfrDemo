package com.hwh.kfr.controller;

import com.hwh.kfr.model.User;
import com.hwh.kfr.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {



    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam("username") String username, @RequestParam("password") String password){
        HashMap<String,Object> map = new HashMap<>();
        User user = userService.login(username, password);
        if (user != null){
            map.put("user",user);
        }
        else {
            map.put("msg","登陆失败");
        }
        return map;
    }
    
}
