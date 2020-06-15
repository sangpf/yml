package com.youchu.product.entity;

import lombok.Data;

@Data
public class Pic {
//    jpg_1.put("width", width);
//    jpg_1.put("height", height);
//    jpg_1.put("type", "jpg");
//    jpg_1.put("content", "D:\\dog.jpg");

    private int width;
    private int height;
    private String type;
    private String content;

    public Pic(String type, String content) {
        this.width = 500;
        this.height = 400;
        this.type = type;
        this.content = content;
    }

}
