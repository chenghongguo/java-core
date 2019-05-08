package com.hongguo.java8.defaultmethod;

/**
 * @author: chenghongguo
 * @date: 2019-05-07
 * @description:
 */
public class ParentImpl implements Parent {

    private String msg;

    @Override
    public void message(String body) {
        msg = body;
    }

    @Override
    public String getLastMessage() {
        return msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
