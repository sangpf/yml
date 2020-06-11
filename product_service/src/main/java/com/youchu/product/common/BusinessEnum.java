package com.youchu.product.common;

public enum BusinessEnum {

    //    bizStatus; // 业务状态 : 应做 shouldDo, 已做 alreadyDo,  未做 notDo
    shouldDo("应做", 1), alreadyDo("已做", 2),
    notDo("未做", 3),toExamine("审核中", 4);

    //成员变量
    private String name;
    private int index;
    //构造方法
    private BusinessEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    //普通方法
    public static String getName(int index) {
        for (BusinessEnum c : BusinessEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    //getset方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

}
