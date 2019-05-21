package com.teiphu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teiphu.http.HttpStatus;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("toUpdateInfo")
    public String toUpdateInfo() {
        return "settings";
    }

    @ApiOperation(value = "保存用户")
    @PutMapping("saveUser")
    public String saveUser(String userName, String password, String email, String phone, String sex,
                           Timestamp birthday, String job, String signature) {
        UserDo user = new UserDo(userName, password, email, phone, sex, birthday, job, signature);
        int res = userService.addUser(user);
        return "";
    }

    @ResponseBody
    @ApiOperation(value = "移除用户")
    @PostMapping("removeUser")
    public String removeUser(Integer id) {
        int res = userService.deleteUser(id);
        return "";
    }

    @ApiOperation(value = "修改用户信息")
    @ResponseBody
    @PostMapping("updateUser")
    public com.teiphu.http.Result updateUser(HttpSession session, String userName, String password, String email, String phone, String sex,
                                             String birthday, String job, String signature, String address) {
        UserDo user = (UserDo) session.getAttribute("user");
        if (!StringUtils.isEmpty(userName)) {
            user.setUsername(userName);
        }
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        if (!StringUtils.isEmpty(email)) {
            user.setEmail(email);
        }
        if (!StringUtils.isEmpty(phone)) {
            user.setPhone(phone);
        }
        if (!StringUtils.isEmpty(sex)) {
            user.setSex(sex);
        }
        if (!StringUtils.isEmpty(birthday)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = simpleDateFormat.parse(birthday);
                Timestamp birth = new Timestamp(date.getTime());
                user.setBirthday(birth);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isEmpty(job)) {
            user.setJob(job);
        }
        if (!StringUtils.isEmpty(signature)) {
            user.setSignature(signature);
        }
        if (!StringUtils.isEmpty(address)) {
            user.setAddress(address);
        }
        int res = userService.updateUser(user);
        if (res > 0) {
            return new com.teiphu.http.Result(HttpStatus.OK.getCode(), HttpStatus.OK.getDesc());
        } else {
            return new com.teiphu.http.Result(HttpStatus.INTERNAL_SERVER_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR.getDesc());
        }
    }

    @ApiOperation(value = "获取用户")
    @GetMapping("retrieveUser")
    public UserDo retrieveUser(Integer userId) {
        UserDo user = userService.getUser(userId);
        return user;
    }

    @ResponseBody
    @ApiOperation(value = "获取多个用户")
    @GetMapping("retrieveUsers")
    public JSONObject retrieveUsers(String name, Integer page, Integer limit) {
        int count = 0;
        List<UserDo> users = null;
        if (!StringUtils.isEmpty(name)) {
            users = userService.listUserByName(name, page, limit);
            count = userService.countUserByName(name);
        } else {
            users = userService.listUser(page, limit);
            count =  userService.countUser();
        }
        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("count", count);
        res.put("msg", "");
        JSONArray userJA = new JSONArray();
        userJA.addAll(users);
        res.put("data", userJA);
        return res;
    }

}
