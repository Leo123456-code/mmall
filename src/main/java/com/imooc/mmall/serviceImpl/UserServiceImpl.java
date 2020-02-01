package com.imooc.mmall.serviceImpl;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mmall.dao.UserMapper;
import com.imooc.mmall.pojo.User;
import com.imooc.mmall.qt.Const;
import com.imooc.mmall.service.IUserService;
import com.imooc.mmall.util.MD5Util;
import com.imooc.mmall.vo.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-22:23
 * email 1437665365@qq.com
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private Gson gson=new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private UserMapper userMapper;


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public ServerResponse<User> login(String username, String password) {
        int row = userMapper.CheckUsername(username);
        if(row==0){
            return ServerResponse.createByMessage("用户名不存在");
        }
        //密码登录MD5
        String MD5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, MD5Password);
        if(user==null){
            return ServerResponse.createByMessage("用户名或密码错误");
        }
        //密码设为空
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",user);
    }

    /**
     * 注册
     * @param user
     * @return
     */

    @Override
    public ServerResponse<String> register(User user) {
        int row = userMapper.CheckUsername(user.getUsername());
        if (row>0){
            return ServerResponse.createByMessage("用户名或密码已存在");
        }
        int rowCount = userMapper.CheckUserEmail(user.getEmail());
        if(rowCount>0){
            return ServerResponse.createByMessage("用户名或密码已存在");
        }
        user.setRole(Const.Role.ROLE_CUSTOMER);
        //MD5加密
//        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int resultCount = userMapper.insertSelective(user);

        if(resultCount==0){
            return ServerResponse.createByMessage("注册失败");
        }
        return ServerResponse.createBySuccess("注册成功");
    }
}
