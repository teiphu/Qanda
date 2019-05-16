package com.teiphu.controller;

import com.teiphu.http.HttpStatus;
import com.teiphu.pojo.Result;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
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

    @Autowired
    private DataSource dataSource;

    /*@Autowired
    private PasswordEncoder passwordEncoder;*/

    /**
     * 用于跳转到注册界面
     * @return
     */
    @GetMapping("/registration")
    public String test() {
        return "register";
    }

    /**
     * 用于跳转到登录界面
     * @return
     */
    @GetMapping("signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("toUpdateInfo")
    public String toUpdateInfo() {
        return "settings";
    }

    /**
     * 登录并写入Session
     * @param session
     * @param email
     * @param phone
     * @param password
     * @return
     */
    @ApiOperation(value = "登录")
    @ResponseBody
    @PostMapping("login")
    public Result login(HttpSession session, String email, String phone, String password) {
        UserDo user = userService.getUserByLogin(email, phone, password);
        Result result = new Result();
        if (user != null) {
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", user);
            UserDo userDo = (UserDo) session.getAttribute("user");
            result.setCode(200);
            result.setMsg("登录成功");
        } else {
            result.setCode(400);
            result.setMsg("登录失败");
        }
        return result;
    }

    /**
     *
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
    @ApiOperation(value = "注册")
    @ResponseBody
    @RequestMapping(value = "/register", produces = "application/json")
    public Result register(String username, String password, String email, String phone) {
        //UserDo user = new UserDo(username, passwordEncoder.encode(password), email, phone);
        UserDo user = new UserDo(username, password, email, phone);
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

    @ApiOperation(value = "获取多个用户")
    @GetMapping("retrieveUsers")
    public List<UserDo> retrieveUsers() {
        List<UserDo> users = userService.listUser();
        return users;
    }
}
