package io.renren.modules.test.dao;

import io.renren.modules.test.entity.ContactEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 联系
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@Mapper
public interface ContactDao extends BaseMapper<ContactEntity> {
	
}
