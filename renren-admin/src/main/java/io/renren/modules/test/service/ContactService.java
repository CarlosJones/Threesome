package io.renren.modules.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.test.entity.ContactEntity;

import java.util.Map;

/**
 * 联系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
public interface ContactService extends IService<ContactEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

