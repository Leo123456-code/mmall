package com.imooc.mmall;

import lombok.Getter;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-22:42
 * email 1437665365@qq.com
 */
@Getter
public enum ResponseCode {

    SUCCESS(0,"成功"),
    ERROR(1,"登录失败"),
    NOT_LOGIN(2,"未登录"),
    ILLEGAL_ARGUUMENT(3,"参数错误"),
    ERROR_FAIL(4,"服务器异常"),
    ;
    private Integer code;
    private String desc;

    ResponseCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
