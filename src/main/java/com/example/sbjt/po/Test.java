package com.example.sbjt.po;

/**
 * @auth: Created by zk on 2018/7/18
 * @description:
 */
public class Test {

    private String sn;

    private String name;

    private TestInner testInner;

    public Test() {
    }

    public Test(String sn, String name, TestInner testInner) {
        this.sn = sn;
        this.name = name;
        this.testInner = testInner;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestInner getTestInner() {
        return testInner;
    }

    public void setTestInner(TestInner testInner) {
        this.testInner = testInner;
    }
}
