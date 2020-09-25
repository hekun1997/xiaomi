package com.xiaomi.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * @Description  
 * @Author  hekun
 * @Date 2020-09-24 
 */
@Data
@Entity
@Table ( name ="shopping" )
public class Shopping implements Serializable {

	private static final long serialVersionUID =  4466123176730406920L;

	@Id
   	@Column(name = "shoppingid" )
	private Integer shoppingid;

	/**
	 * 用户表id
	 */
   	@Column(name = "userid" )
	private Integer userid;

	/**
	 * 订单id
	 */
   	@Column(name = "orderid" )
	private Integer orderid;

	/**
	 * 收货姓名
	 */
   	@Column(name = "receivername" )
	private String receivername;

	/**
	 * 收货固定电话
	 */
   	@Column(name = "receiverphone" )
	private String receiverphone;

	/**
	 * 收货移动电话
	 */
   	@Column(name = "receivermobile" )
	private String receivermobile;

	/**
	 * 省份
	 */
   	@Column(name = "receiverprovince" )
	private String receiverprovince;

	/**
	 * 城市
	 */
   	@Column(name = "receivercity" )
	private String receivercity;

	/**
	 * 区/县
	 */
   	@Column(name = "receiverdistrict" )
	private String receiverdistrict;

	/**
	 * 详细地址
	 */
   	@Column(name = "receiveraddress" )
	private String receiveraddress;

   	@Column(name = "createtime" )
	private Date createtime;

   	@Column(name = "updatetime" )
	private Date updatetime;

}
