package com.xiaomi.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

/**
 * @Description  
 * @Author  hekun
 * @Date 2020-09-24 
 */

@Data
@Builder
@Entity
@Table (name ="user")
public class User implements Serializable {

	private static final long serialVersionUID =  733372334550822734L;

	/**
	 * 用户表id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "userid" )
	private Integer userid;

	/**
	 * 用户名
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * 用户密码，MD5加密
	 */
   	@Column(name = "password" )
	private String password;

   	@Column(name = "phone" )
	private String phone;

	/**
	 * 找回密码问题
	 */
   	@Column(name = "question" )
	private String question;

	/**
	 * 找回密码答案
	 */
   	@Column(name = "answer" )
	private String answer;

	/**
	 * 角色0-管理员,1-普通用户
	 */
   	@Column(name = "role" )
	private Integer role;

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
