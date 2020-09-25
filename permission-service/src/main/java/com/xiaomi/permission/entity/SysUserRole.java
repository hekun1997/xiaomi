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
@Table ( name ="sys_user_role" )
public class SysUserRole implements Serializable {

	private static final long serialVersionUID =  7584135681459021385L;

	/**
	 * 主键
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 用户id
	 */
   	@Column(name = "uid" )
	private Integer uid;

	/**
	 * 角色id
	 */
   	@Column(name = "role_id" )
	private Integer roleId;

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
