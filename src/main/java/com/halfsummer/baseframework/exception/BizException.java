package com.halfsummer.baseframework.exception;

/**
 * 
* @Title: BizException
* @Description: 业务异常类
* @Version:1.0.0  
* @author
* @date
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	protected Integer errorCode;
	/**
	 * 错误信息
	 */
	protected String errorMsg;

	public BizException() {
		super();
	}

	public BizException(BaseInfoInterface errorInfoInterface) {
		super(errorInfoInterface.getResultCode().toString());
		this.errorCode = errorInfoInterface.getResultCode();
		this.errorMsg = errorInfoInterface.getResultMsg();
	}
	
	public BizException(BaseInfoInterface errorInfoInterface, Throwable cause) {
		super(errorInfoInterface.getResultCode().toString(), cause);
		this.errorCode = errorInfoInterface.getResultCode();
		this.errorMsg = errorInfoInterface.getResultMsg();
	}
	
	public BizException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
	
	public BizException(Integer errorCode, String errorMsg) {
		super(errorCode.toString());
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public BizException(Integer errorCode, String errorMsg, Throwable cause) {
		super(errorCode.toString(), cause);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}


	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getMessage() {
		return errorMsg;
	}

	/**
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

}
