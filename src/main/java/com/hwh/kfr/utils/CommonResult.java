package com.hwh.kfr.utils;

import java.io.Serializable;


/**
 * 相同结果响应体格式实体类
 * 2019年10月11日10:13:01
 * @param <T>
 */
public final class CommonResult<T> implements Serializable {

    private int status = 1;

    private String errorCode = "";

    private String errorMsg = "";

    private T resultBody;

    public CommonResult() {
    }

    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResultBody() {
        return resultBody;
    }

    public void setResultBody(T resultBody) {
        this.resultBody = resultBody;
    }
}
