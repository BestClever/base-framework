package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.halfsummer.baseframework.result.DataGridResultInfo;
import com.halfsummer.baseframework.result.ResultInfo;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 分页查询列表
    * @param ${lowerEntityName}
    * @return
    */
    DataGridResultInfo selectPageList(${entity} ${lowerEntityName}, int limit, int page);

    /**
    * 新增数据
    * @param ${lowerEntityName}
    */
    ResultInfo add${entity}(${entity} ${lowerEntityName});

    /**
    * 修改数据
    * @param ${lowerEntityName}
    */
    ResultInfo edit${entity}(${entity} ${lowerEntityName});

    /**
    * 查看详情
    * @param ${keyPropertyName}
    * @return
    */
    ResultInfo getDetailsById(${keyPropertyType} ${keyPropertyName});

    /**
    * 删除数据
    * @param ${keyPropertyName}
    * @return
    */
    ResultInfo deleteById(${keyPropertyType} ${keyPropertyName});

    /**
    * 批量删除
    * @param ids
    * @return
    */
    ResultInfo deleteBatch(List<Long> ids);

}

