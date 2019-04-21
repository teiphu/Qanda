package com.teiphu.controller;

import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:58
 **/
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @PutMapping("saveUser")
    public String saveUser(UserDo user) {
        int res = userService.addUser(user);
        return "";
    }

    @ResponseBody
    @DeleteMapping("removeUser")
    public String removeUser(Integer userId) {
        int res = userService.deleteUser(userId);
        return "";
    }

    @ResponseBody
    @PostMapping("changeUser")
    public String changeUser(UserDo user) {
        int res = userService.updateUser(user);
        return "";
    }

    @ResponseBody
    @GetMapping("retrieveUser")
    public UserDo retrieveUser(Integer userId) {
        UserDo user = userService.getUser(userId);
        return user;
    }

    @ResponseBody
    @GetMapping("retrieveUsers")
    public List<UserDo> retrieveUsers() {
        List<UserDo> users = userService.listUser();
        return users;
    }
}
