package com.xiaomi.commodity.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  hekun
 * @Date 2020-09-24 
 */

public class Product implements Serializable {

	private static final long serialVersionUID =  6717877847524311409L;

	/**
	 * 商品id
	 */
	private Integer proid;

	/**
	 * 类别Id
	 */
	private Integer cateid;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 商品副标题
	 */
	private String subtitle;

	/**
	 * 产品主图,url相对地址
	 */
	private String mainimage;

	/**
	 * 图片地址,json格式,扩展用
	 */
	private String subimages;

	/**
	 * 商品详情
	 */
	private String detail;

	/**
	 * 价格,单位-元保留两位小数
	 */
	private Double price;

	/**
	 * 库存数量
	 */
	private Long stock;

	/**
	 * 商品状态.1-在售 2-下架 3-删除
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	private Date createtime;

	/**
	 * 更新时间
	 */
	private Date updatetime;

}
