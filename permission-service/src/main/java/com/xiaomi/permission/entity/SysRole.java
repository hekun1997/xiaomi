package com.xiaomi.permission.entity;

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
 * @Date 2020-09-25 
 */

@Data
@ToString
@Entity
@Table ( name ="sys_role" )
public class SysRole implements Serializable {

	private static final long serialVersionUID =  1506555385090111707L;

	/**
	 * 主键
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 是否可用Y可用  N不可用
	 */
   	@Column(name = "available" )
	private String available;

	/**
	 * 角色标识程序中判断使用,如"admin"
	 */
   	@Column(name = "role" )
	private String role;

	/**
	 * 角色描述,UI界面显示使用
	 */
   	@Column(name = "description" )
	private String description;

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
