package com.base.dockerfiledemo.vo.response;

import lombok.Data;

@Data
public class BaseResponseVO<T>{
    private Integer status;
    private String msg;
    private T entity;

    public BaseResponseVO(Integer status, String msg, T entity) {
        this.status = status;
        this.msg = msg;
        this.entity = entity;
    }
}
