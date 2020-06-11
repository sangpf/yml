package com.youchu.product.common;

import java.util.Objects;

public enum BizStatusEnum {
    NEW("new", "新增"),
    IN_REVIEW("inReview", "审批中"),
    COMPLETE("complete", "完成");

    private String code;

    private String text;

    private BizStatusEnum(String code, String text){
        this.code = code;
        this.text = text;
    }



    public static BizStatusEnum fromCode(String status){
        for(BizStatusEnum refer : BizStatusEnum.values()) {
            if (Objects.equals(refer.getCode(),status)) {
                return refer;
            }
        }
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
