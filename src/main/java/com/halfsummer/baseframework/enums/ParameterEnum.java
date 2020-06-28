package com.halfsummer.baseframework.enums;


import com.halfsummer.baseframework.exception.BaseInfoInterface;

/**
 * @Title: ParameterEnum
 * @Description: 公用描述枚举类
 * @Version:1.0.0
 * @author halfsummer
 * @date 2018年6月25日
 */
public enum ParameterEnum implements BaseInfoInterface {
	// 参数定义

	;


	private Integer resultCode;


	private String resultMsg;

	ParameterEnum(Integer resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	@Override
	public Integer getResultCode() {
		return resultCode;
	}

	@Override
	public String getResultMsg() {
		return resultMsg;
	}

}
