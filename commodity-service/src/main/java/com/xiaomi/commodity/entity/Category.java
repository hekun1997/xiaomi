package com.xiaomi.commodity.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  hekun
 * @Date 2020-09-24 
 */
public class Category implements Serializable {

	private static final long serialVersionUID =  60123791142694113L;

	/**
	 * 类别Id
	 */
	private Integer cateid;

	/**
	 * 父类别id当id=0时说明是根节点,一级类别
	 */
	private Integer parentid;

	/**
	 * 类别名称
	 */
	private String name;

	/**
	 * 类别状态1-正常,2-已废弃
	 */
	private Integer status;

	/**
	 * 排序编号,同类展示顺序,数值相等则自然排序
	 */
	private Integer sortorder;

	/**
	 * 创建时间
	 */
	private Date createtime;

	/**
	 * 更新时间
	 */
	private Date updatetime;

}
