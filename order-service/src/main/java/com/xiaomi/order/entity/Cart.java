package com.xiaomi.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * @Description  
 * @Author  hekun
 * @Date 2020-09-24 
 */
@Data
@Entity
@Table ( name ="cart" )
public class Cart implements Serializable {

	private static final long serialVersionUID =  4625197972940662053L;

	@Id
   	@Column(name = "carid" )
	private Integer carid;

	/**
	 * 用户表id
	 */
   	@Column(name = "userid" )
	private Integer userid;

	/**
	 * 商品id
	 */
   	@Column(name = "proid" )
	private Integer proid;

	/**
	 * 数量
	 */
   	@Column(name = "quantity" )
	private Long quantity;

	/**
	 * 是否选择,1=已勾选,0=未勾选
	 */
   	@Column(name = "checked" )
	private Integer checked;

	/**
	 * 创建时间
	 */
   	@Column(name = "createtime" )
	private Date createtime;

	/**
	 * 更新时间
	 */
   	@Column(name = "updatetime" )
	private Date updatetime;

}
