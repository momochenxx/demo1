package com.momochen.controller;

import com.momochen.vo.BeanResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/info")
    @ResponseBody
    public BeanResult getUserInfo(){

        return new BeanResult(100,"SUCCESS");
    }
}
