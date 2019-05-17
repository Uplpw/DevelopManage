/**
 * 
 */
package com.manage.bean;

/**
 * @author lpw
 *
 */
public class TB_User {
	public TB_User() {
	}
	
	/**
	 * 属性名与表字段同名
	 */
	private String username;// 用户名
	private String password;// 密码
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
