package io.renren.modules.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.test.entity.AboutEntity;

import java.util.Map;

/**
 * 关于
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
public interface AboutService extends IService<AboutEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

