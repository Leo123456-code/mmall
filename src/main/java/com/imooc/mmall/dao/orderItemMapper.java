package com.imooc.mmall.dao;

import com.imooc.mmall.pojo.orderItem;

public interface orderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(orderItem record);

    int insertSelective(orderItem record);

    orderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(orderItem record);

    int updateByPrimaryKey(orderItem record);
}