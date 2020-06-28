package com.halfsummer.baseframework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author BestClever
 * @title: AspectApi
 * @projectName base-framework
 * @description: 装饰器模式
 * @date 2020-06-07 11:34
 */
public interface AspectApi {

    Object doHandlerAspect(ProceedingJoinPoint pjp, Method method)throws Throwable;
}
