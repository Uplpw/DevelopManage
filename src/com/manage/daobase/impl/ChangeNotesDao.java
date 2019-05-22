package com.manage.daobase.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manage.bean.TB_AboutUs;
import com.manage.util.DBUtil;


public class ChangeNotesDao {
	
		
		//餐厅简介
		public TB_AboutUs selectA()
		{
			TB_AboutUs au=new TB_AboutUs();
			
			String sql="SELECT * FROM tb_aboutus WHERE pk=1";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					au.setName(rs.getString("name"));
					au.setContent(rs.getString("content"));	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeJDBC(null, pstmt, conn);
			}
			System.out.println(au.getName());
			System.out.println(au.getContent());
			return au;
		}
		
		public boolean changeA(TB_AboutUs au) {
			String sql = "UPDATE tb_aboutus SET content=? WHERE pk=1";
			Connection conn = DBUtil.getConnection();
			boolean flag = true;
			PreparedStatement pstmt = null;
			int count=0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, au.getContent());
				count =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				if(count !=1) flag=false;
			} finally {
				DBUtil.closeJDBC(null, pstmt, conn);
				// TODO Auto-generated catch block
			}
			return flag;
		}
		
		public TB_AboutUs selectB()
		{
			TB_AboutUs au=new TB_AboutUs();
			
			String sql="SELECT * FROM tb_aboutus WHERE pk=2";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					au.setName(rs.getString("name"));
					au.setContent(rs.getString("content"));	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeJDBC(null, pstmt, conn);
			}
			System.out.println(au.getName());
			System.out.println(au.getContent());
			return au;
		}
		
		public boolean changeB(TB_AboutUs au) {
			String sql = "UPDATE tb_aboutus SET content=? WHERE pk=2";
			Connection conn = DBUtil.getConnection();
			boolean flag = true;
			PreparedStatement pstmt = null;
			int count=0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, au.getContent());
				count =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				if(count !=1) flag=false;
			} finally {
				DBUtil.closeJDBC(null, pstmt, conn);
				// TODO Auto-generated catch block
			}
			return flag;
		}
		
		public TB_AboutUs selectC()
		{
			TB_AboutUs au=new TB_AboutUs();
			
			String sql="SELECT * FROM tb_aboutus WHERE pk=3";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					au.setName(rs.getString("name"));
					au.setContent(rs.getString("content"));	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeJDBC(null, pstmt, conn);
			}
			System.out.println(au.getName());
			System.out.println(au.getContent());
			return au;
		}
	
		public boolean changeC(TB_AboutUs au) {
			String sql = "UPDATE tb_aboutus SET content=? WHERE pk=3";
			Connection conn = DBUtil.getConnection();
			boolean flag = true;
			PreparedStatement pstmt = null;
			int count=0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, au.getContent());
				count =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				if(count !=1) flag=false;
			} finally {
				DBUtil.closeJDBC(null, pstmt, conn);
				// TODO Auto-generated catch block
			}
			return flag;
		}
		
		public TB_AboutUs selectD()
		{
			TB_AboutUs au=new TB_AboutUs();
			
			String sql="SELECT * FROM tb_aboutus WHERE pk=4";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					au.setName(rs.getString("name"));
					au.setContent(rs.getString("content"));	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeJDBC(null, pstmt, conn);
			}
			System.out.println(au.getName());
			System.out.println(au.getContent());
			return au;
		}
		
		public boolean changeD(TB_AboutUs au) {
			String sql = "UPDATE tb_aboutus SET content=? WHERE pk=4";
			Connection conn = DBUtil.getConnection();
			boolean flag = true;
			PreparedStatement pstmt = null;
			int count=0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, au.getContent());
				count =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				if(count !=1) flag=false;
			} finally {
				DBUtil.closeJDBC(null, pstmt, conn);
				// TODO Auto-generated catch block
			}
			return flag;
		}
	
}
	

