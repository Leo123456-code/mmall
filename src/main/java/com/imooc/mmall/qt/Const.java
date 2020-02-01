package com.imooc.mmall.qt;

/**
 * created by Leo徐忠春
 * created Time 2020/1/12-0:08
 * email 1437665365@qq.com
 */

import lombok.Data;

/**
 * 常量
 */
@Data
public class Const {
    public static final String CURRENT_USER="currentUser";

    public interface Role{
        int ROLE_CUSTOMER=0;//普通用户
        int ROLE_ADMIN=1;//管理员
    }
}
