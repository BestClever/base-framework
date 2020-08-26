package com.halfsummer.baseframework.exception;

import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultDataUtil;
import com.halfsummer.baseframework.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 
* @Title: GlobalExceptionHandler
* @Description: 全局异常处理
如果使用@RestControllerAdvice 注解
则会将返回的数据类型转换成JSON格式
* @Version:1.0.0  
* @author pancm
* @date 2018年10月24日
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 处理自定义的业务异常
	 * @param req
	 * @param e
	 * @return
	 */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
	public ResultInfo bizExceptionHandler(HttpServletRequest req, BizException e){
    	logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
    	return ResultDataUtil.createFail(e.getErrorCode(),e.getErrorMsg());
    }

	/**
	 * 处理空指针的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =NullPointerException.class)
	@ResponseBody
	public ResultInfo exceptionHandler(HttpServletRequest req, NullPointerException e){
		logger.error("发生空指针异常！原因是:",e);
		return ResultDataUtil.createFail(CommonEnum.BODY_NOT_MATCH);
	}

	/**
	 * 参数校验失败
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =MethodArgumentNotValidException.class)
	@ResponseBody
	public ResultInfo methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
		logger.error("发生参数校验失败！原因是:",e);
		// 从异常对象中拿到ObjectError对象
		ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
		return ResultDataUtil.createFail(CommonEnum.BODY_NOT_MATCH).setData(objectError.getDefaultMessage());
	}

    /**
        * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
	@ResponseBody
	public ResultInfo exceptionHandler(HttpServletRequest req, Exception e){
    	logger.error("未知异常！原因是:",e);
       	return ResultDataUtil.createFail(CommonEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ArithmeticException.class)
	@ResponseBody
	public ResultInfo arithmeticExceptionHandler(HttpServletRequest req, Exception e){
		logger.error("未知异常！原因是:",e);
		return ResultDataUtil.createFail(CommonEnum.ARITHMETIC_ERROR);
	}

}
