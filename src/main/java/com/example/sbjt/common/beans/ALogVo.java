package com.example.sbjt.common.beans;

import java.util.Map;

/**
 * @auth: Created by zk on 2018/7/12
 * @description: 日志输出对象
 */
public class ALogVo {

    private String d_startTime;

    private String e_spendTime;

    private String c_uri;

    private String a_methodName;

    private String b_methodType;

    private Map<String,Object> fromParams;

    private Object result;

    public String getD_startTime() {
        return d_startTime;
    }

    public void setD_startTime(String d_startTime) {
        this.d_startTime = d_startTime;
    }

    public String getE_spendTime() {
        return e_spendTime;
    }

    public void setE_spendTime(String e_spendTime) {
        this.e_spendTime = e_spendTime;
    }

    public String getC_uri() {
        return c_uri;
    }

    public void setC_uri(String c_uri) {
        this.c_uri = c_uri;
    }

    public String getA_methodName() {
        return a_methodName;
    }

    public void setA_methodName(String a_methodName) {
        this.a_methodName = a_methodName;
    }

    public String getB_methodType() {
        return b_methodType;
    }

    public void setB_methodType(String b_methodType) {
        this.b_methodType = b_methodType;
    }

    public Map<String, Object> getFromParams() {
        return fromParams;
    }

    public void setFromParams(Map<String, Object> fromParams) {
        this.fromParams = fromParams;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
