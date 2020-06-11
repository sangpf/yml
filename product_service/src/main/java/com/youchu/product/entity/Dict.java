package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 岗位字典实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dict {
    private String id;

    private String dictCode;

    private String dictName;

    private String showName;

    private String innerSort;

    private String subCode;

}