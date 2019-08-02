package io.renren.modules.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.test.dao.FeedbackDao;
import io.renren.modules.test.entity.FeedbackEntity;
import io.renren.modules.test.service.FeedbackService;


@Service("feedbackService")
public class FeedbackServiceImpl extends ServiceImpl<FeedbackDao, FeedbackEntity> implements FeedbackService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedbackEntity> page = this.page(
                new Query<FeedbackEntity>().getPage(params),
                new QueryWrapper<FeedbackEntity>()
        );

        return new PageUtils(page);
    }

}
