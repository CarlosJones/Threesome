package io.renren.modules.test.dao;

import io.renren.modules.test.entity.FeedbackEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 反馈信息
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@Mapper
public interface FeedbackDao extends BaseMapper<FeedbackEntity> {
	
}
