package com.momochen.service;

import com.momochen.model.User;

/**
 * Created by momochen on 2016/3/31.
 */

public interface UserService {
    /**
     * 插入用户数据
     *
     * @param user
     */
    int insertUser(User user);

    /**
     * 更新登录信息
     *
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 获取当前数据库用户信息
     *
     * @param uid
     * @return
     */
    User selectByPrimaryKey(Integer uid);

    /**
     * 根据uname获取当前数据库用户信息
     *
     * @param uname
     * @return
     */
    User selectByUname(String uname);
}
