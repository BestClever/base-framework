package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.halfsummer.baseframework.result.DataGridResultInfo;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.baseframework.constant.SystemConst;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


/**
 * <p>
 * ${table.comment!}前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Controller
@RequestMapping("/${lowerEntityName}")
public class ${table.controllerName} {

    private static final String PREFIX = SystemConst.VIEW_PREFIX + "${lowerEntityName}";

    @Autowired
    private ${table.serviceName} ${lowerServiceName};

    /**
    * 跳转到主页面
    */
    @GetMapping
    public String index() {
        return PREFIX + "/${lowerEntityName}";
    }

    /**
    * 跳转到新增页面
    */
    @GetMapping("/add")
    public String add() {
        return PREFIX + "/${lowerEntityName}_add";
    }

    /**
    * 跳转到修改页面
    */
    @GetMapping("/edit")
    public String edit() {
        return PREFIX + "/${lowerEntityName}_edit";
    }

    /**
    * 查询列表
    * @param ${lowerEntityName}
    * @param limit
    * @param page
    * @return
    */
    @RequestMapping("/list")
    @ResponseBody
    public DataGridResultInfo pageList(${entity} ${lowerEntityName}, int limit, int page) {
      return ${lowerServiceName}.selectPageList(${lowerEntityName},limit,page);
    }

    /**
    * 新增数据
    * @param ${lowerEntityName}
    * @return
    */
    @RequestMapping("/add${entity}")
    @ResponseBody
    public ResultInfo add${entity}(${entity} ${lowerEntityName}) {
        return ${lowerServiceName}.add${entity}(${lowerEntityName});
    }

    /**
    * 修改数据
    * @param ${lowerEntityName}
    * @return
    */
    @RequestMapping("/edit${entity}")
    @ResponseBody
    public ResultInfo edit${entity}(${entity} ${lowerEntityName}) {
        return ${lowerServiceName}.edit${entity}(${lowerEntityName});
    }

    /**
    * 查看详情
    * @param ${keyPropertyName}
    * @return
    */
    @RequestMapping("/detail")
    @ResponseBody
    public ResultInfo detail(${keyPropertyType} ${keyPropertyName}) {
        return ${lowerServiceName}.getDetailsById(${keyPropertyName});
    }

    /**
    * 根据ID删除记录
    * @param ${keyPropertyName}
    * @return
    */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo delete(${keyPropertyType} ${keyPropertyName}) {
        return ${lowerServiceName}.deleteById(${keyPropertyName});
    }

    /**
    * 批量删除数据
    * @param ids ID集合
    * @return
    */
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public ResultInfo deleteBatch(@RequestParam(value = "ids[]",required = true) List<Long> ids) {
        return ${lowerServiceName}.deleteBatch(ids);
    }

}
