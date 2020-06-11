package com.youchu.product.common;

import java.util.Objects;

public enum BizStatusShowEnum {
    SHOULD_DO("shouldDo", "应做"),
    NOT_DO("notDo", "未做"),
    IN_REVIEW("inReview", "审批中"),
    ALREADY_DO("alreadyDo", "已做");

    private String code;

    private String text;

    private BizStatusShowEnum(String code, String text){
        this.code = code;
        this.text = text;
    }



    public static BizStatusShowEnum fromCode(String status){
        for(BizStatusShowEnum refer : BizStatusShowEnum.values()) {
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
