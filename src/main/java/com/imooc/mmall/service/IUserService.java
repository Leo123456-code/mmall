package com.imooc.mmall.service;

import com.imooc.mmall.pojo.User;
import com.imooc.mmall.vo.ServerResponse;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-22:19
 * email 1437665365@qq.com
 */
public interface IUserService {
         //登录
    ServerResponse<User> login(String username, String password);
        //注册
    ServerResponse<String> register(User user);

}
