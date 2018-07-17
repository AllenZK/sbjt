package com.example.sbjt.common.beans;

/**
 * @auth: Created by zk on 2018/7/13
 * @description:
 */
public class StateCode<T> {

    private String code;

    private String message;

    private T data;


    public StateCode() {
    }

    public StateCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
