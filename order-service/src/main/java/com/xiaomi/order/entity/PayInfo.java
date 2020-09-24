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
@Table ( name ="payinfo" )
public class PayInfo implements Serializable {

	private static final long serialVersionUID =  3934618482660955160L;

	@Id
   	@Column(name = "payid" )
	private Integer payid;

	/**
	 * 订单id
	 */
   	@Column(name = "orderid" )
	private Long orderid;

	/**
	 * 用户表id
	 */
   	@Column(name = "userid" )
	private Long userid;

	/**
	 * 支付平台:1-支付宝,2-微信
	 */
   	@Column(name = "payplatform" )
	private Long payplatform;

	/**
	 * 支付流水号
	 */
   	@Column(name = "platformnumber" )
	private String platformnumber;

	/**
	 * 支付状态
	 */
   	@Column(name = "platformstatus" )
	private String platformstatus;

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
