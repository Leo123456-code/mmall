package com.imooc.mmall.dao;

import com.imooc.mmall.pojo.payInfo;

public interface payInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(payInfo record);

    int insertSelective(payInfo record);

    payInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(payInfo record);

    int updateByPrimaryKey(payInfo record);
}