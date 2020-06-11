package com.youchu.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

  private String emplCode;
  private String emplName;
  private String postCode;
  private String noticeFlag;
  private String isDelete;
  private String orgCode;
  private String orgName;
}
