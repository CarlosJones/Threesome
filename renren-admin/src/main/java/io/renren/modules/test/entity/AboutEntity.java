package io.renren.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 关于
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@Data
@TableName("about")
public class AboutEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 关于名称
	 */
	private String aboutName;
	/**
	 * 关于描述
	 */
	private String aboutNotes;
	/**
	 * 关于图片
	 */
	private String aboutPic;

}
