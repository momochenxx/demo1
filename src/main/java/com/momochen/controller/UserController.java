package com.momochen.controller;

import com.momochen.common.constant.Constants;
import com.momochen.common.utils.ValidateUtils;
import com.momochen.model.User;
import com.momochen.service.UserService;
import com.momochen.vo.BeanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by momochen on 2016/3/31.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public BeanResult add(String uname, String upass) {
        if (ValidateUtils.isEmpty(uname) || ValidateUtils.isEmpty(upass)) {
            return new BeanResult(102, Constants.NOTICE_PARAM_NULL);
        }

        User user = userService.selectByUname(uname);

        if(user!=null){
            return new BeanResult(102, "用户名已存在");
        }

        user = new User();
        user.setUname(uname);
        user.setUpass(upass);
        int id = userService.insertUser(user);
        if (id > 0) {
            return new BeanResult(100, user.getUid() + " " + id);
        }

        return new BeanResult(104, id + "");
    }

}
