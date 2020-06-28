package com.halfsummer.baseframework.util;

import lombok.Data;

/**
 * @author BestClever
 * @title: PageVo
 * @projectName base-framework
 * @description: TODO
 * @date 2020-06-07 20:39
 */
@Data
public class PageVo {
    private int page=1;//代表当前页码
    private int limit=10;//代表每页数据量
}
