package com.momochen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by momochen on 2016/3/31.
 */
@Controller
public class Test {
    private String SUCCESS = "success";

    @RequestMapping("/hello")
    public String hello() {
        return SUCCESS;
    }
}
