package com.teiphu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Teiphu
 * @Creation 2019.05.02 下午 12:45
 **/
@Controller
public class TestController {

    @GetMapping("/")
    public String test() {
        return "register";
    }
}
