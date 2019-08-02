package io.renren.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@Data
@TableName("contact")
public class ContactEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 公司名称
	 */
	private String contactCoName;
	/**
	 * 描述
	 */
	private String contactNotes;
	/**
	 * 邮件
	 */
	private String contactEmail;
	/**
	 * 地址
	 */
	private String contactAddress;
	/**
	 * 电话
	 */
	private String contactTel;

}
