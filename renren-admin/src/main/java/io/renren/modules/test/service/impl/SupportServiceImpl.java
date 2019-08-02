package io.renren.modules.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.test.dao.SupportDao;
import io.renren.modules.test.entity.SupportEntity;
import io.renren.modules.test.service.SupportService;


@Service("supportService")
public class SupportServiceImpl extends ServiceImpl<SupportDao, SupportEntity> implements SupportService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SupportEntity> page = this.page(
                new Query<SupportEntity>().getPage(params),
                new QueryWrapper<SupportEntity>()
        );

        return new PageUtils(page);
    }

}
