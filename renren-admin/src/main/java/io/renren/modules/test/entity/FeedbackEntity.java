package io.renren.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 反馈信息
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@Data
@TableName("feedback")
public class FeedbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 邮件
	 */
	private String feedbackEmail;
	/**
	 * 电话
	 */
	private String feedbackTel;
	/**
	 * 描述
	 */
	private String feedbackNotes;
	/**
	 * 图片
	 */
	private String feedbackPic;
	/**
	 * 国家
	 */
	private String feedbackCountry;
	/**
	 * 公司名称
	 */
	private String feedbackCoName;

}
