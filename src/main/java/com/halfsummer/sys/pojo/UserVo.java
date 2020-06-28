package com.halfsummer.sys.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author BestClever
 * @title: UserVo
 * @projectName base-framework
 * @description: TODO
 * @date 2020-06-07 20:59
 */
@Data
public class UserVo {
    /**
     * 用户主键
     */
    private String userNo;

    /**
     * 是电话号码，也是账号（登录用）
     */
    private String userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态值（1：启用，2：禁用，3：删除）
     */
    private String status;

    /**
     * 职位
     */
    private String job;
}
