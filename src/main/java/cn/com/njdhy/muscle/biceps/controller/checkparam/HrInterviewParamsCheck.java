package cn.com.njdhy.muscle.biceps.controller.checkparam;

import cn.com.njdhy.muscle.biceps.model.HrInterview;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 参数校验
 *
 * @author jason.hu
 * @date 2018-08-02
 */
public class HrInterviewParamsCheck extends BaseParamsCheck {

    /**
     * 校验对象参数是否合法
     *
     * @param hrInterview 参数对象
     * @return 是否合法
     */
    public static boolean check(HrInterview hrInterview) {
        return ObjectUtils.isEmpty(hrInterview);
    }
}
