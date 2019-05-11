package com.teiphu.http;

/**
 * @Author Teiphu
 * @Creation 2019.05.11 上午 02:12
 **/
public class Result {

    private int code;
    private String desc;
    private String data;

    public Result(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Result(int code, String desc, String data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
