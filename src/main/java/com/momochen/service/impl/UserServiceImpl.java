package com.momochen.service.impl;

import com.momochen.dao.UserMapper;
import com.momochen.model.User;
import com.momochen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by momochen on 2016/3/31.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    public int updateUserInfo(User user) {
        return 0;
    }

    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    public User selectByUname(String uname) {
        return userMapper.selectUserByUsername(uname);
    }
}
