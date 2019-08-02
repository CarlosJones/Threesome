package io.renren.modules.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.test.dao.SubProductsDao;
import io.renren.modules.test.entity.SubProductsEntity;
import io.renren.modules.test.service.SubProductsService;


@Service("subProductsService")
public class SubProductsServiceImpl extends ServiceImpl<SubProductsDao, SubProductsEntity> implements SubProductsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SubProductsEntity> page = this.page(
                new Query<SubProductsEntity>().getPage(params),
                new QueryWrapper<SubProductsEntity>()
        );

        return new PageUtils(page);
    }

}
