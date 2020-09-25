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
@Table ( name ="orders" )
public class Orders implements Serializable {

	private static final long serialVersionUID =  4324976524989499725L;

	/**
	 * 订单id
	 */
	@Id
   	@Column(name = "orderid" )
	private Integer orderid;

	/**
	 * 用户id
	 */
   	@Column(name = "userid" )
	private Integer userid;

   	@Column(name = "shoppingid" )
	private Integer shoppingid;

	/**
	 * 实际付款金额,单位是元,保留两位小数
	 */
   	@Column(name = "payment" )
	private Double payment;

	/**
	 * 支付类型,1-在线支付
	 */
   	@Column(name = "paymenttype" )
	private Integer paymenttype;

	/**
	 * 运费,单位是元
	 */
   	@Column(name = "postage" )
	private Long postage;

	/**
	 * 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
	 */
   	@Column(name = "status" )
	private Integer status;

	/**
	 * 支付时间
	 */
   	@Column(name = "paymenttime" )
	private Date paymenttime;

	/**
	 * 发货时间
	 */
   	@Column(name = "sendtime" )
	private Date sendtime;

	/**
	 * 交易完成时间
	 */
   	@Column(name = "endtime" )
	private Date endtime;

	/**
	 * 交易关闭时间
	 */
   	@Column(name = "closetime" )
	private Date closetime;

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
