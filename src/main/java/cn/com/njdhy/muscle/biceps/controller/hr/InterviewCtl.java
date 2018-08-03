
package cn.com.njdhy.muscle.biceps.controller.hr;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.controller.checkparam.HrInterviewParamsCheck;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.sys.InterviewErrorCode;
import cn.com.njdhy.muscle.biceps.exception.sys.UserErrorCode;
import cn.com.njdhy.muscle.biceps.model.HrInterview;
import cn.com.njdhy.muscle.biceps.model.SysRole;
import cn.com.njdhy.muscle.biceps.service.hr.HrInterviewService;
import cn.com.njdhy.muscle.biceps.util.ShiroUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 面试人员管理控制器
 *
 * @author 胡志海
 */
@RestController
@RequestMapping("/sys/interview")
public class InterviewCtl {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewCtl.class);

    @Autowired
    private HrInterviewService hrInterviewService;

    /**
     * 查询面试人员列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result index(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {

        try {
            // 参数校验不通过
            if (HrInterviewParamsCheck.check(params)) {
                return Result.error(InterviewErrorCode.QUERY_PARAMS_ISNULL_ERROR_CODE, InterviewErrorCode.QUERY_PARAMS_ISNULL_ERROR_MSG);
            }
            Query queryParam = new Query(params);
            PageInfo<HrInterview> result = hrInterviewService.queryList(queryParam, pageNumber, pageSize);
            return Result.success(result.getTotal(), result.getList());
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.error(InterviewErrorCode.INSERT_ERROR_CODE, InterviewErrorCode.INSERT_ERROR_MSG);
        }
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {

        try {
            // 参数校验不通过
            if (HrInterviewParamsCheck.check(id)) {
                return Result.error(InterviewErrorCode.INSERT_ERROR_CODE, InterviewErrorCode.INSERT_ERROR_MSG);
            }
            HrInterview model = hrInterviewService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new HrInterview();
            }
            return Result.success().put("model", model);
        } catch (ApplicationException e) {
            LOGGER.error(e.getCode(), e.getMessage());
            return Result.error(InterviewErrorCode.INSERT_ERROR_CODE, InterviewErrorCode.INSERT_ERROR_MSG);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return Result.error(InterviewErrorCode.INSERT_ERROR_CODE, InterviewErrorCode.INSERT_ERROR_MSG);
        }
    }

    /**
     * 保存
     *
     * @param hrInterview 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody HrInterview hrInterview) {
        try {
            // 校验参数不通过
            if (HrInterviewParamsCheck.check(hrInterview)) {
                return Result.error(InterviewErrorCode.INSERT_PARAMS_ISNULL_ERROR_CODE, InterviewErrorCode.INSERT_PARAMS_ISNULL_ERROR_MSG);
            }

            // 登记人
            hrInterview.setRecordUser(ShiroUtil.getLoginUserName());

            // 执行入库操作
            hrInterviewService.insert(hrInterview);
            return Result.success();
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.error(InterviewErrorCode.INSERT_ERROR_CODE, InterviewErrorCode.INSERT_ERROR_MSG);
        }
    }

    /**
     * 修改操作
     *
     * @param hrInterview 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody HrInterview hrInterview) {

        try {
            // 校验参数不通过
            if (HrInterviewParamsCheck.check(hrInterview)) {
                return Result.error(InterviewErrorCode.UPDATE_PARAMS_ISNULL_ERROR_CODE, InterviewErrorCode.UPDATE_PARAMS_ISNULL_ERROR_MSG);
            }
            // 执行修改
            hrInterviewService.update(hrInterview);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error(InterviewErrorCode.UPDATE_ERROR_CODE, InterviewErrorCode.UPDATE_ERROR_MSG);
        } catch (Exception e) {
            return Result.error(InterviewErrorCode.UPDATE_ERROR_CODE, InterviewErrorCode.UPDATE_ERROR_MSG);
        }
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            // 校验参数不通过
            if (HrInterviewParamsCheck.check(ids)) {
                return Result.error(InterviewErrorCode.DELETE_ID_ISNULL_ERROR_CODE, InterviewErrorCode.DELETE_ID_ISNULL_ERROR_MSG);
            }
            hrInterviewService.deleteByIds(ids);
            return Result.success();
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

}