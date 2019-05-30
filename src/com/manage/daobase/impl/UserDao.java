/**
 * 
 */
package com.manage.daobase.impl;

import com.manage.bean.TB_User;
import com.manage.daobase.*;

/**
 * @author lpw
 *
 */
public class UserDao extends BaseDao<TB_User, Integer> {
	public UserDao() {
		//必须显性初始化
		super(TB_User.class);
	}
}
