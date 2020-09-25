package com.xiaomi.permission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

/**
 * @Description  
 * @Author  hekun
 * @Date 2020-09-25 
 */
@Data
@Builder
@Entity
@Table ( name ="sys_permission" )
public class SysPermission implements Serializable {

	private static final long serialVersionUID =  3354731069064737751L;

	/**
	 * 主键
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 父编号,本权限可能是该父编号权限的子权限
	 */
   	@Column(name = "parent_id" )
	private Integer parentId;

	/**
	 * 父编号列表
	 */
   	@Column(name = "parent_ids" )
	private String parentIds;

	/**
	 * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
	 */
   	@Column(name = "permission" )
	private String permission;

	/**
	 * 资源类型，[menu|button]
	 */
   	@Column(name = "resource_type" )
	private String resourceType;

	/**
	 * 资源路径 如：/userinfo/list
	 */
   	@Column(name = "url" )
	private String url;

	/**
	 * 权限名称
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 是否可用0可用  1不可用
	 */
   	@Column(name = "available" )
	private String available;

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
