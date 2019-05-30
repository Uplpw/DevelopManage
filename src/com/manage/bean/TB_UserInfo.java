/**
 * 
 */
package com.manage.bean;

/**
 * @author IGK_DLS
 *
 */
public class TB_UserInfo {
	String username;
	String petName;
	String userPicture;
	String userTelephone;
	String userReal;
	Long userCredit;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserReal() {
		return userReal;
	}

	public void setUserReal(String userReal) {
		this.userReal = userReal;
	}

	public Long getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(long userCredit) {
		this.userCredit = userCredit;
	}

}
