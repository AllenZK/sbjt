package com.example.sbjt.po;

/**
 * @auth: Created by zk on 2018/7/31
 * @description:
 */
public class TestInner {

    private String type = "123456S";

    private String code;

    public TestInner() {
    }

    public TestInner(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
