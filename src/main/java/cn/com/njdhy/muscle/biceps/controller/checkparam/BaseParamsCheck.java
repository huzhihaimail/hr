package cn.com.njdhy.muscle.biceps.controller.checkparam;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 通用参数校验
 *
 * @author jason.hu
 * @date 2018-08-02
 */
public class BaseParamsCheck {

    /**
     * 校验对象参数是否合法
     *
     * @param map 参数对象
     * @return 是否合法
     */
    public static boolean check(Map map) {
        return ObjectUtils.isEmpty(map);
    }

    /**
     * 校验对象参数是否合法
     *
     * @param collection 参数对象
     * @return 是否合法
     */
    public static boolean check(Collection collection) {
        return ObjectUtils.isEmpty(collection);
    }

    /**
     * 校验id是否合法
     *
     * @param id 唯一标志
     * @return 是否合法
     */
    public static boolean check(String id) {
        return StringUtils.isEmpty(id);
    }
}
