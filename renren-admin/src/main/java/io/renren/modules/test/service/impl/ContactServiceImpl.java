package io.renren.modules.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.test.dao.ContactDao;
import io.renren.modules.test.entity.ContactEntity;
import io.renren.modules.test.service.ContactService;


@Service("contactService")
public class ContactServiceImpl extends ServiceImpl<ContactDao, ContactEntity> implements ContactService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ContactEntity> page = this.page(
                new Query<ContactEntity>().getPage(params),
                new QueryWrapper<ContactEntity>()
        );

        return new PageUtils(page);
    }

}
