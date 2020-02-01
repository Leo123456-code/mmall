package com.imooc.mmall.vo;

import lombok.Data;

import java.util.Date;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-23:31
 * email 1437665365@qq.com
 */
@Data
public class UserVo {

    private Integer id;

    private String username;

    private String email;

    private String phone;

    private Integer role;

    private Date createTime;

    private Date updateTime;


}
