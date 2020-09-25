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
@Table ( name ="sys_role_permission" )
public class SysRolePermission implements Serializable {

	private static final long serialVersionUID =  4621347600985800335L;

	/**
	 * 主键
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 角色id
	 */
   	@Column(name = "role_id" )
	private Integer roleId;

	/**
	 * 权限id
	 */
   	@Column(name = "permission_id" )
	private Integer permissionId;

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
