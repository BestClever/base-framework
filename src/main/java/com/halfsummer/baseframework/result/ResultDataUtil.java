package com.halfsummer.baseframework.result;




import com.halfsummer.baseframework.exception.BaseInfoInterface;
import com.halfsummer.baseframework.exception.BizException;

import java.util.List;

/**
 *  ResponseDataUtil:返回的工具类,主要是方便返回的写法
 *  * 单纯的返回工具类,直接放在这个包
 */
public class ResultDataUtil {

    /**
     * 返回成功描述和数据详情
     * @param baseInfoInterface
     * @return
     */
    public static ResultInfo createSuccess(BaseInfoInterface baseInfoInterface){
        return new ResultInfo().setSucess(true).setCode(baseInfoInterface.getResultCode()).setMsg(baseInfoInterface.getResultMsg());
    }


    /**
     * 返回失败 使用枚举类的方式
     * @param baseInfoInterface
     * @return
     */
    public static ResultInfo createFail(BaseInfoInterface baseInfoInterface){
        return new ResultInfo().setSucess(false).setCode(baseInfoInterface.getResultCode()).setMsg(baseInfoInterface.getResultMsg());
    }

    /**
     * 失败
     */
    public static ResultInfo createFail(Integer code, String message) {
        return new ResultInfo().setSucess(false).setCode(code).setMsg(message);
    }


    /**
     * 创建查询结果信息 专门为 数据表格设计
     * @param pageInfo
     * @return
     */
    public static DataGridResultInfo createQueryResult(PageInfo pageInfo){
        return new DataGridResultInfo(pageInfo.getTotal(),pageInfo.getList());
    }

    /**ui
     * 抛出异常
     * @param baseInfoInterface
     * @throws
     */
    public static void throwExcepion(BaseInfoInterface baseInfoInterface) throws BizException {
        throw new BizException(baseInfoInterface);
    }

}
