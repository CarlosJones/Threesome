package io.renren.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 子产品
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@Data
@TableName("sub_products")
public class SubProductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 子产品名称
	 */
	private String subProductName;
	/**
	 * 子产品描述
	 */
	private String subProductNotes;
	/**
	 * 子产品描述
	 */
	private String subProductPic;
	/**
	 * paren-id
	 */
	private Integer parentid;

}
