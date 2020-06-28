package com.halfsummer.baseframework.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BestClever
 * @title: ActiveUser
 * @projectName base-framework
 * @description: 存储当前用户
 * @date 2020-06-05 21:39
 */
@Data
public class ActiveUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userNo;//主键
    private String userId;//用户id（主键）
    private String userName;// 用户名称
    private String avatar;//头像
    private Integer status;//状态值（1：启用，2：禁用，3：删除）
}
