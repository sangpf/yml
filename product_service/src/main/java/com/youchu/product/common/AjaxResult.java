package com.youchu.product.common;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;

	/**
	 * 成功并返回信息
	 */
	public static AjaxResult successResult(Integer returnCode, String returnMsg){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("returnCode", returnCode);
		ajaxResult.put("returnMsg", returnMsg);
		return ajaxResult;
	}
	
	public static AjaxResult successResult(){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("returnCode", "0");
		ajaxResult.put("returnMsg", "success");
		return ajaxResult;
	}
	
	/**
	 * 错误并返回信息
	 * @param errorMsg
	 * @return
	 */
	public static AjaxResult errorResult(String errorMsg){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", false);
		ajaxResult.put("msg", errorMsg);
		return ajaxResult;
	}
	
	public static AjaxResult errorResult(){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("returnCode", 10001);
		ajaxResult.put("returnMsg", "fail");
		return ajaxResult;
	}
	
	/**
	 * 错误并返回信息
	 * @param errorMsg
	 * @return
	 */
	public static AjaxResult errorCode(String errorMsg, String errorCode){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", false);
		ajaxResult.put("msg", errorMsg);
		ajaxResult.put("errorCode", errorCode);
		return ajaxResult;
	}
	
	public static AjaxResult errorCode(String errorMsg, Integer errorCode){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", false);
		ajaxResult.put("msg", errorMsg);
		ajaxResult.put("errorCode", errorCode);
		return ajaxResult;
	}
	
}
