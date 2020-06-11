package com.youchu.product.entity;

import lombok.Data;

@Data
public class CustCheck {

    private String custNo;   // 客户编号
    private int custStatus;  // 客户风险状态  0 正常,  1 非正常

}
