package com.youchu.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 借据实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanReceiptDto {
  private String queryType;
  private Long no;
  private String custName;
  private String custCode;
  private String emplCode;
  private String emplName;
  private String orgName;

}
