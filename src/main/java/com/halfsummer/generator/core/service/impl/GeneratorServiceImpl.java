package com.halfsummer.generator.core.service.impl;

import com.halfsummer.baseframework.constant.GenConst;
import com.halfsummer.generator.pagination.Pagination;
import com.halfsummer.generator.config.DbConfig;
import com.halfsummer.generator.core.entity.FieldInfo;
import com.halfsummer.generator.core.entity.TableInfo;
import com.halfsummer.generator.core.service.GeneratorService;
import com.halfsummer.generator.pagination.LayPage;
import com.halfsummer.generator.pagination.PaginationFactory;
import com.halfsummer.generator.toolkit.MysqlDataBaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代码生成Service 实现类
 *
 * @author Bamboo
 * @since 2020-03-19
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private MysqlDataBaseUtil dataBaseUtil;

    @Autowired
    private DbConfig dataSource;


    /**
     * 获取数据库中的表
     *
     * @param tableName 表名
     * @param tableDescribe 表描述
     * @return 数据库中的表集合(分页)
     */
    @Override
    public LayPage getTables(String tableName, String tableDescribe) {
        // 判断是否支持当前数据库
        if( !dataSource.getUrl().contains(GenConst.DB_MYSQL)) {
            return LayPage.fail("抱歉，暂不支持该数据库");
        }
        String schemaName = dataBaseUtil.getDbName(dataSource);
        Pagination page = PaginationFactory.getPagination();
        Pagination<TableInfo> data = dataBaseUtil.getTables(page,schemaName,tableName,tableDescribe);
        return LayPage.buildPagination(data);
    }

    /**
     * 获取表所有字段
     *
     * @param tableName 表名
     * @return 表字段集合(全部)
     */
    @Override
    public LayPage getFields(String tableName) {
        String schemaName = dataBaseUtil.getDbName(dataSource);
        List<FieldInfo> list =  dataBaseUtil.getFields(schemaName,tableName);
        return LayPage.buildPagination(list);
    }
}
