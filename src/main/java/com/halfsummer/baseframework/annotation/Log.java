package com.halfsummer.baseframework.annotation;

import java.lang.annotation.*;

/**
 * @author BestClever
 * @title: Log
 * @projectName base-framework
 * @description: 在Controller方法上加入改注解会自动记录日志
 * @date 2020-06-07 11:39
 */
@Target( { ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface Log {
    /**
     * 模块名称
     */
    String modelName() default "";

    /**
     * 操作
     */
    String action()default "";
    /**
     * 描述.
     */
    String description() default "";
}
