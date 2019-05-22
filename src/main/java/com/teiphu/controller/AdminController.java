package com.teiphu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Teiphu
 * @Creation 2019.05.19 上午 10:51
 **/
@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("getUserManager")
    public String getUserManager() {
        return "user-manager";
    }

    @GetMapping("getAdminUserManager")
    public String getAdminUserManager() {
        return "admin/user-manager";
    }

    @GetMapping("getAdminQuestionManager")
    public String getAdminQuestionManager() {
        return "admin/question-manager";
    }

    @GetMapping("getQaManagerIndex")
    public String getQaManagerIndex() {
        return "qa-manager-index";
    }
}
