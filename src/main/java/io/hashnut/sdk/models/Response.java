package io.hashnut.sdk.models;

import io.hashnut.sdk.config.PayConstant;

public class Response<T> {
    // 返回码",example = "0"
    public int resultCode;
    // 返回消息
    public String resultMsg;
    // 返回数据
    public T data;

    public Response<T> success() {
        this.resultCode= PayConstant.RESULT_CODE_SUCCESS;
        this.resultMsg= PayConstant.RESULT_MSG_SUCCESS;
        return this;
    }

    public Response<T> fail() {
        this.resultCode= PayConstant.RESULT_CODE_FAILED;
        this.resultMsg= PayConstant.RESULT_MSG_FAILED;
        return this;
    }

    public Response<T> fail(String msg) {
        this.resultCode= PayConstant.RESULT_CODE_FAILED;
        this.resultMsg=msg;
        return this;
    }

    public Response<T> exception() {
        this.resultCode= PayConstant.RESULT_CODE_EXCEPTION;
        this.resultMsg= PayConstant.RESULT_MSG_EXCEPTION;
        return this;
    }

    public Response<T> exception(String msg) {
        this.resultCode= PayConstant.RESULT_CODE_FAILED;
        this.resultMsg=msg;
        return this;
    }

    public Response<T> unauthorized() {
        this.resultCode= PayConstant.RESULT_CODE_UNAUTHORIZED;
        this.resultMsg= PayConstant.RESULT_MSG_UNAUTHORIZED;
        return this;
    }

    public Response<T> unauthorized(String msg) {
        this.resultCode= PayConstant.RESULT_CODE_UNAUTHORIZED;
        this.resultMsg=msg;
        return this;
    }

    public Response<T> unauthenticated() {
        this.resultCode= PayConstant.RESULT_CODE_UNAUTHENTICATED;
        this.resultMsg= PayConstant.RESULT_MSG_UNAUTHENTICATED;
        return this;
    }

    public Response<T> unauthenticated(String msg) {
        this.resultCode= PayConstant.RESULT_CODE_UNAUTHENTICATED;
        this.resultMsg=msg;
        return this;
    }

    public Response<T> data(T data) {
        this.data=data;
        return this;
    }
}
