package com.halfsummer.baseframework.aspect;

import com.halfsummer.baseframework.config.Constant;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author BestClever
 * @title: AspectApiImpl
 * @projectName base-framework
 * @description: 基本被装饰类,做一些公共处理
 * @date 2020-06-07 11:33
 */
public class AspectApiImpl implements AspectApi {
    @Override
    public Object doHandlerAspect(ProceedingJoinPoint pjp, Method method) throws Throwable {
        Constant.isPass=false;
        return null;
    }
}
