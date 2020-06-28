package com.halfsummer.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.halfsummer.sys.entity.OperationLog;
import com.halfsummer.sys.mapper.OperationLogMapper;
import com.halfsummer.sys.service.OperationLogService;
import org.springframework.stereotype.Service;

/**
 * @author BestClever
 * @title: OperationLogServiceImpl
 * @projectName base-framework
 * @description: TODO
 * @date 2020-06-07 11:45
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService  {
}
