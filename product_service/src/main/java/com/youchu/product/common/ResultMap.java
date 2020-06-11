package com.youchu.product.common;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {

    public static Map<String, Object> successResult(){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("result", "success");
        data.put("message", "success");
        return data;
    }

    public static Map<String, Object> errorResult(){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("result", "fail");
        data.put("message", "错误信息提示");
        return data;
    }

}
