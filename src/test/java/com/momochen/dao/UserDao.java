package com.momochen.dao;

import com.momochen.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by momochen on 2016/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDao {
    @Autowired
    UserMapper userMapper;

    @Test
    public void selectById(){
        User user = userMapper.selectByPrimaryKey(1);

        System.out.println(user.toString());

    }

    @Test
    public void selectByUname(){
        User user = userMapper.selectUserByUsername("momochen");

        System.out.println(user.toString());
    }

    @Test
    public void inset(){
        User user = new User();
        user.setUname("momochen");
        user.setUpass("momochen");
        userMapper.insert(user);
    }
}
