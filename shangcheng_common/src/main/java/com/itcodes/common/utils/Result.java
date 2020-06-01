package com.itcodes.common.utils;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1967884482557278502L;
    @NonNull
    private boolean flag;   //是否成功
    @NonNull
    private Integer code;   //返回码
    @NonNull
    private String message; //返回消息
    private T data;         //返回数据

}
