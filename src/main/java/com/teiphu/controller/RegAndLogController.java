package com.teiphu.controller;

import com.teiphu.pojo.Result;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * @Author Teiphu
 * @Creation 2019.05.19 下午 03:45
 **/
@Controller
@RequestMapping("/reglog")
public class RegAndLogController {

    @Autowired
    private UserService userService;

    /**
     * 用于跳转到注册界面
     * @return
     */
    @GetMapping("/registration")
    public String test() {
        return "register";
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

    /**
     * 用于跳转到登录界面
     * @return
     */
    @GetMapping("signin")
    public String signin() {
        return "signin";
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

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "signin";
    }

    /*@Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;*/

    /**
     * 用于跳转到注册界面
     * @return
     */
    /*@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String test() {
        return "register";
    }*/

    /**
     *
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
    /*@ApiOperation(value = "注册")
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(String username, String password, String email, String phone) {
        //UserDo user = new UserDo(username, passwordEncoder.encode(password), email, phone);
        //password = passwordEncoder.encode(password);
        password = DigestUtils.md5Hex(password);
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
    }*/

}
