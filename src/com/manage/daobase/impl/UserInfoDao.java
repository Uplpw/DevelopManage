/**
 * 
 */
package com.manage.daobase.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.manage.bean.TB_UserInfo;
import com.manage.daobase.BaseDao;
import com.manage.util.DBUtil;

/**
 * @author IGK_DLS
 *
 */
public class UserInfoDao extends BaseDao<TB_UserInfo, Integer> {
	/**
	 * 
	 */
	public UserInfoDao() {
		super(TB_UserInfo.class);
	}

	public ArrayList<TB_UserInfo> findAllUserByPetName(String petName) {
		return (ArrayList<TB_UserInfo>) findBy("petname", petName, null, true);
	}

	public ArrayList<TB_UserInfo> findAllUserByPetName(String petName, int start, int num) {
		return (ArrayList<TB_UserInfo>) findLimitProperty("petname", petName, null, true, start, num);
	}

	public ArrayList<TB_UserInfo> findNotCustomer() {
		return (ArrayList<TB_UserInfo>) findNotProperty("petName", "顾客", null, true);
	}

	public ArrayList<TB_UserInfo> findNotCustomer(int start, int num) {

		String sql = "select * from " + entityClass.getSimpleName();
		sql += " where " + " petname " + " != " + "'顾客'" + " limit " + start + " , " + num;
		return (ArrayList<TB_UserInfo>) getAllProtected(sql);
	}

	public boolean removeStaffSingleLine(TB_UserInfo tb_UserInfo) {

		int rst = super.remove(tb_UserInfo);
		if (rst == 1) {
			return true;
		}
		return false;
	}

	public boolean saveStaffSingleLine(TB_UserInfo tb_UserInfo) {
		try {
			super.save(tb_UserInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 完成任务先写完
	public boolean updateStaffSingleLine(TB_UserInfo tb_UserInfo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update " + entityClass.getSimpleName() + " set ";
			ArrayList<String> keys = new ArrayList<>();
			ArrayList<String> values = new ArrayList<>();

			/*
			 * String username; String petName; String userPicture; String
			 * userTelephone; String userReal;
			 */

			sql += " petName = '" + tb_UserInfo.getPetName() + "' ,userTelephone  = '" + tb_UserInfo.getUserTelephone()
					+ "'";

			sql += " where " + " username " + " = " + " '" + tb_UserInfo.getUsername() + "' ";
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.closeJDBC(null, preparedStatement, connection);
		}
	}
}
