package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.DataGridResultInfo;
import com.halfsummer.baseframework.result.PageInfo;
import com.halfsummer.baseframework.result.ResultDataUtil;
import com.halfsummer.baseframework.result.ResultInfo;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
    * 分页查询列表
    * @param ${lowerEntityName}
    * @return
    */
    @Override
    public DataGridResultInfo selectPageList(${entity} ${lowerEntityName}, int limit, int page)  {
        Page pageContext = new Page(page,limit);
        Page<${entity}> pageList = this.baseMapper.selectPage(pageContext, ${lowerEntityName});
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(pageList.getTotal());
        pageInfo.setList(pageList.getRecords());
        return ResultDataUtil.createQueryResult(pageInfo);
    }

    /**
    * 新增数据
    * @param ${lowerEntityName}
    */
    @Override
    public ResultInfo add${entity}(${entity} ${lowerEntityName}) {
        int addCount = baseMapper.insert(${lowerEntityName});
        if (addCount > 0) {
            return ResultDataUtil.createSuccess(CommonEnum.ADD_SUCCESS);
        }
        return ResultDataUtil.createFail(CommonEnum.ADD_FAILURE);
    }

    /**
    * 修改数据
    * @param ${lowerEntityName}
    */
    @Override
    public ResultInfo edit${entity}(${entity} ${lowerEntityName}) {
        int updateCount = baseMapper.updateById(${lowerEntityName});
        if (updateCount > 0) {
            return ResultDataUtil.createSuccess(CommonEnum.UPDATE_SUCCESS);
        }
        return ResultDataUtil.createFail(CommonEnum.UPDATE_FAILURE);
    }

    /**
    * 查看详情
    * @param ${keyPropertyName}
    * @return
    */
    @Override
    public ResultInfo getDetailsById(${keyPropertyType} ${keyPropertyName}) {
        return ResultDataUtil.createSuccess(CommonEnum.SUCCESS).setData(baseMapper.selectById(${keyPropertyName}));
    }

    /**
    * 删除数据
    * @param ${keyPropertyName}
    * @return
    */
    @Override
    public ResultInfo deleteById(${keyPropertyType} ${keyPropertyName}) {
        int deleteCount = baseMapper.deleteById(${keyPropertyName});
        if (deleteCount > 0) {
            return ResultDataUtil.createSuccess(CommonEnum.REMOVE_SUCCESS);
        }
        return ResultDataUtil.createFail(CommonEnum.REMOVE_FAILURE);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public ResultInfo deleteBatch(List<Long> ids) {
        int deleteBatchCount = baseMapper.deleteBatchIds(ids);
        if (deleteBatchCount > 0) {
            return ResultDataUtil.createSuccess(CommonEnum.REMOVE_BATCH_SUCCESS);
        }
        return ResultDataUtil.createFail(CommonEnum.REMOVE_BATCH_FAILURE);
    }

}

