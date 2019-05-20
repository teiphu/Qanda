package com.teiphu.controller;

import com.teiphu.NoticeTask;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.Result;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.session.InMemoryWebSessionStore;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.teiphu.pojo.UserDo.scheduledExecutorService;

/**
 * @Author Teiphu
 * @Creation 2019.05.19 下午 03:45
 **/
@Controller
@RequestMapping("/reglog")
public class RegAndLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegAndLogController.class);

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
            //session.setAttribute("userId", user.getId());
            //UserDo userDo = (UserDo) session.getAttribute("user");
            Set<AnswerDo> answers = new HashSet<>();
            List<AnswerDo> answerList =  userService.listAnswerToTheQuestionOfConcern(user.getId(), user.getGmtLogout());
            answers.addAll(answerList);
            LOGGER.info("set size: " + answers.size());
            user.setAnswers(answers);
            session.setAttribute("user", user);
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(new NoticeTask(user), 0, 4, TimeUnit.SECONDS);
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
