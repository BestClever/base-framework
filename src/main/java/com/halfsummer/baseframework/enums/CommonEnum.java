package com.halfsummer.baseframework.enums;


import com.halfsummer.baseframework.exception.BaseInfoInterface;

/**halfsummer
 * @Title: CommonEnum
 * @Description: 公用描述枚举类
 * @Version:1.0.0
 * @author pancm
 * @date 2018年6月25日
 */
public enum CommonEnum implements BaseInfoInterface {
	// 数据操作错误定义
	SUCCESS(200, "成功!"),
	BODY_NOT_MATCH(400,"请求的数据格式不符!"),
	SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
	NOT_FOUND(404, "未找到该资源!"),
	INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
	SERVER_BUSY(503,"服务器正忙，请稍后再试!"),

	ARITHMETIC_ERROR(1100,"数学运算错误!"),
	SAVE_FAILED(101,"保存失败,请重试"),
	DATA_DOESNT_EXIST(10086,"该用户无排队信息"),

	//用户模块 成功
	LOGIN_SUCCESS(2000,"登录成功"),
	//失败
	NOT_EXIST_USER(2050,"不存在该用户"),
	PASSWORD_ERROR(2051,"密码错误"),
	USER_FORBIDDEN(2052,"用户被禁用"),
	USER_DELETE(2053,"用户被禁用"),

	/*查询*/
	SELECT_SUCCESS(9001,"查询成功！"),
	SELECT_FAILURE(9051,"查询失败！"),
	/*添加*/
	ADD_SUCCESS(9101, "新增成功！"),
	ADD_FAILURE(9151, "新增失败！"),
	/*更新*/
	UPDATE_SUCCESS(9201, "更新成功！"),
	UPDATE_FAILURE(9251, "更新失败！"),
	/*删除*/
	REMOVE_SUCCESS(9301, "删除成功！"),
	REMOVE_FAILURE(9351, "删除失败！"),
	/*删除*/
	REMOVE_BATCH_SUCCESS(9401, "批量删除成功！"),
	REMOVE_BATCH_FAILURE(9451, "批量删除失败！"),
	;

	/** 错误码 */
	private Integer resultCode;

	/** 错误描述 */
	private String resultMsg;

	CommonEnum(Integer resultCode, String resultMsg) {
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
