package io.renren.modules.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.test.entity.FeedbackEntity;

import java.util.Map;

/**
 * 反馈信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
public interface FeedbackService extends IService<FeedbackEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

