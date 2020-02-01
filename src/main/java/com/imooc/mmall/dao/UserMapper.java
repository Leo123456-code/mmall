package com.imooc.mmall.dao;

import com.imooc.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);



    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //查看名字是否存在
    int CheckUsername(String username);
    //
    User selectLogin(@Param("username") String username,
                     @Param("password") String password);
    //查看邮箱是否存在
    int CheckUserEmail(String email);
    //
    int insertSelective(User record);

}