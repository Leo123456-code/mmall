package com.imooc.mmall.vo;

/**
 * created by Leo徐忠春
 * created Time 2020/1/11-22:24
 * email 1437665365@qq.com
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.mmall.ResponseCode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 通用的返回值
 */
@Slf4j
@Data
//序列化value为null的不显示value,key依然显示
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private Integer status;
    private String msg;
    private T data;

    public ServerResponse(Integer status){

        this.status=status;
    }

    public ServerResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ServerResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    //序列化之后不会显示
    @JsonIgnore

    public boolean isSuccess(){

        return this.status== ResponseCode.SUCCESS.getCode();
    }

    public static<T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static<T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static<T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static<T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static<T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),
                ResponseCode.ERROR.getDesc());
    }
    public static<T> ServerResponse<T> createByMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),
                errorMessage);
    }
    public static<T> ServerResponse<T> createByErrorCode(Integer errorCode,
                                                         String errorMessage){
        return new ServerResponse<T>(errorCode,
                errorMessage);
    }




}
