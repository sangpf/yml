package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

  private String emplCode;
  private String emplName;
  private String postCode;
  private String noticeFlag;
  private String createTime;
  private String updateTime;
  private String id;
  private String isDelete;

}
