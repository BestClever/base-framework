package com.halfsummer.baseframework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author BestClever
 * @title: AbstractAspectManager
 * @projectName base-framework
 * @description: TODO
 * @date 2020-06-07 11:37
 */
public abstract class AbstractAspectManager implements AspectApi{
    private AspectApi aspectApi;

    public AbstractAspectManager(AspectApi aspectApi){
        this.aspectApi=aspectApi;
    }

    public  Object doHandlerAspect(ProceedingJoinPoint pjp, Method method)throws Throwable{
        return this.aspectApi.doHandlerAspect(pjp,method);
    }

    protected abstract Object execute(ProceedingJoinPoint pjp, Method method)throws Throwable;
}
