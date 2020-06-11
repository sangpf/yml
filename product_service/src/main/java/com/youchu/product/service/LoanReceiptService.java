package com.youchu.product.service;

import com.youchu.product.common.ApiResponse;
import com.youchu.product.dto.LoanReceiptDto;
import com.youchu.product.entity.LoanReceipt;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LoanReceiptService {

	/**
	 * 根据参数查询列表
	 */
	List<LoanReceipt> getListByParams(LoanReceiptDto loanReceiptDto);

	/**
	 * 导入借据台账
	 * @param file
	 * @return
	 */
	ApiResponse uploadExcel(MultipartFile file);

	/**
	 * 模糊查询机构代理列表
	 */
	List<String> getOrgNameList(String orgName);
}
