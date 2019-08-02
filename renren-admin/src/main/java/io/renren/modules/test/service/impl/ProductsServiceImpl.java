package io.renren.modules.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.test.dao.ProductsDao;
import io.renren.modules.test.entity.ProductsEntity;
import io.renren.modules.test.service.ProductsService;


@Service("productsService")
public class ProductsServiceImpl extends ServiceImpl<ProductsDao, ProductsEntity> implements ProductsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductsEntity> page = this.page(
                new Query<ProductsEntity>().getPage(params),
                new QueryWrapper<ProductsEntity>()
        );

        return new PageUtils(page);
    }

}
