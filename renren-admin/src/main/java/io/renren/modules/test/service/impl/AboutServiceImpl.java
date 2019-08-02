package io.renren.modules.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.test.dao.AboutDao;
import io.renren.modules.test.entity.AboutEntity;
import io.renren.modules.test.service.AboutService;


@Service("aboutService")
public class AboutServiceImpl extends ServiceImpl<AboutDao, AboutEntity> implements AboutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AboutEntity> page = this.page(
                new Query<AboutEntity>().getPage(params),
                new QueryWrapper<AboutEntity>()
        );

        return new PageUtils(page);
    }

}
