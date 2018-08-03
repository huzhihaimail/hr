package cn.com.njdhy.muscle.biceps.exception.sys;

/**
 * 面试人员信息配置表
 *
 * @author jason.hu
 * @date 2018-08-02
 */
public interface InterviewErrorCode {

    /**
     * 面试人员模块代码前缀
     */
    String MODULE_PREFIX = "Interview";

    /**
     * 面试人员模块消息前缀
     */
    String MODULE_MSG_PREFIX = "面试管理:";
    String MODULE_CODE = "5000";

    /**
     * 删除异常
     */
    String DELETE_ID_ISNULL_ERROR_CODE = MODULE_PREFIX + MODULE_CODE + "1";
    String DELETE_ID_ISNULL_ERROR_MSG = MODULE_MSG_PREFIX + "批量删除出现系统异常";

    /**
     * 更新异常
     */
    String UPDATE_ERROR_CODE = MODULE_PREFIX + MODULE_CODE + "2";
    String UPDATE_ERROR_MSG = MODULE_MSG_PREFIX + "批量删除出现系统异常";

    /**
     * 插入异常
     */
    String INSERT_ERROR_CODE = MODULE_PREFIX + MODULE_CODE + "3";
    String INSERT_ERROR_MSG = MODULE_MSG_PREFIX + "新增系统异常";

    /**
     * 插入参数为空异常
     */
    String INSERT_PARAMS_ISNULL_ERROR_CODE = MODULE_PREFIX + MODULE_CODE + "4";
    String INSERT_PARAMS_ISNULL_ERROR_MSG = MODULE_MSG_PREFIX + "新增参数异常";

    /**
     * 修改参数为空异常
     */
    String UPDATE_PARAMS_ISNULL_ERROR_CODE = MODULE_PREFIX + MODULE_CODE + "5";
    String UPDATE_PARAMS_ISNULL_ERROR_MSG = MODULE_MSG_PREFIX + "修改参数异常";

    /**
     * 查询参数异常
     */
    String QUERY_PARAMS_ISNULL_ERROR_CODE = MODULE_PREFIX + MODULE_CODE + "6";
    String QUERY_PARAMS_ISNULL_ERROR_MSG = MODULE_MSG_PREFIX + "查询参数异常";

}
