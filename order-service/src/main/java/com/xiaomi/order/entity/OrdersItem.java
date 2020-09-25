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
@Table ( name ="orderitem" )
public class OrdersItem implements Serializable {

	private static final long serialVersionUID =  5052293552260820727L;

	/**
	 * 订单子表id
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 订单id
	 */
   	@Column(name = "orderid" )
	private Integer orderid;

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
	 * 商品名称
	 */
   	@Column(name = "proname" )
	private String proname;

	/**
	 * 商品图片地址
	 */
   	@Column(name = "proimage" )
	private String proimage;

	/**
	 * 生成订单时的商品单价，单位是元,保留两位小数
	 */
   	@Column(name = "currentunitprice" )
	private Double currentunitprice;

	/**
	 * 商品数量
	 */
   	@Column(name = "quantity" )
	private Integer quantity;

	/**
	 * 商品总价,单位是元,保留两位小数
	 */
   	@Column(name = "totalprice" )
	private Double totalprice;

   	@Column(name = "createtime" )
	private Date createtime;

   	@Column(name = "updatetime" )
	private Date updatetime;

}
