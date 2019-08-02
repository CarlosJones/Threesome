package io.renren.modules.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.test.entity.SupportEntity;

import java.util.Map;

/**
 * 服务
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
public interface SupportService extends IService<SupportEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

