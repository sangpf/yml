package com.youchu.product.common;

import lombok.Builder;

/**
 * Created by fe on 16/11/21.
 */
@Builder
public class ApiResponse {
    public static final String DEFAULT_STATUS_SUCCESS = "000000";
    public static final String DEFAULT_STATUS_fail = "111111";

    private String status;
    private Object data;
    private String msg;

    public ApiResponse() {
        this.status = DEFAULT_STATUS_SUCCESS;
    }

    public ApiResponse(Object data) {
        this.status = DEFAULT_STATUS_SUCCESS;
        this.data = data;
    }

    public ApiResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ApiResponse(String status, Object data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ApiResponse errorApiResponse(String msg) {
        return  new ApiResponse(DEFAULT_STATUS_fail,msg);
    }


    public static ApiResponse successApiResponse(Object data) {
        return  new ApiResponse(data);
    }

    public static ApiResponse successApiResponse() {
        return  new ApiResponse();
    }

    public ApiResponse withData(Object data) {
        this.data = data;
        return this;
    }
}
