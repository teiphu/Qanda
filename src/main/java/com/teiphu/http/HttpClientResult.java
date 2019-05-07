package com.teiphu.http;

import com.teiphu.http.HttpStatus;

/**
 * @Author Teiphu
 * @Creation 2019.05.08 上午 12:38
 **/
public class HttpClientResult {

    private HttpStatus status;
    private String result;

    public HttpClientResult(HttpStatus status, String result) {
        this.status = status;
        this.result = result;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public String toString() {
        return "HttpClientResult{" +
                "status=" + status.getCode() +
                ", result='" + result + '\'' +
                '}';
    }
}
