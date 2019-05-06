package com.teiphu.controller;

import com.teiphu.pojo.Result;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:58
 **/
@Api(tags = "用户控制器")
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String test() {
        return "register";
    }

    @GetMapping("signin")
    public String signin() {
        return "signin";
    }

    @ApiOperation(value = "登录")
    @ResponseBody
    @PostMapping("login")
    public Result login(HttpSession session, String email, String phone, String password) {
        UserDo user = userService.getUserByLogin(email, phone, password);
        Result result = new Result();
        if (user != null) {
            session.setAttribute("userId", user.getId());
            result.setCode(200);
            result.setMsg("登录成功");
        } else {
            result.setCode(400);
            result.setMsg("登录失败");
        }
        return result;
    }

    @ApiOperation(value = "注册")
    @ResponseBody
    @RequestMapping(value = "/register", produces = "application/json")
    public Result register(String username, String password, String email, String phone) {
        UserDo user = new UserDo(username, passwordEncoder.encode(password), email, phone);
        int res = userService.addUser(user);
        Result result = new Result();

        if (res > 0) {
            result.setCode(200);
            result.setMsg("注册成功");
        } else {
            result.setCode(400);
            result.setMsg("注册失败");
        }
        return result;
    }

    @ApiOperation(value = "保存用户")
    @PutMapping("saveUser")
    public String saveUser(String userName, String password, String email, String phone, String sex,
                           Timestamp birthday, String job, String signature) {
        LOGGER.info(dataSource.toString());

        UserDo user = new UserDo(userName, password, email, phone, sex, birthday, job, signature);
        int res = userService.addUser(user);
        return "";
    }

    @ApiOperation(value = "移除用户")
    @DeleteMapping("removeUser")
    public String removeUser(Integer userId) {
        int res = userService.deleteUser(userId);
        return "";
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("changeUser")
    public String changeUser(Integer id, String userName, String password, String email, String phone, String sex,
                             Timestamp birthday, String job, String signature) {
        UserDo user = new UserDo(id, userName, password, email, phone, sex, birthday, job, signature);
        int res = userService.updateUser(user);
        return "";
    }

    @ApiOperation(value = "获取用户")
    @GetMapping("retrieveUser")
    public UserDo retrieveUser(Integer userId) {
        UserDo user = userService.getUser(userId);
        return user;
    }

    @ApiOperation(value = "获取多个用户")
    @GetMapping("retrieveUsers")
    public List<UserDo> retrieveUsers() {
        List<UserDo> users = userService.listUser();
        return users;
    }
}
