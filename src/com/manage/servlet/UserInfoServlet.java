package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.manage.bean.TB_UserInfo;
import com.manage.daobase.impl.UserInfoDao;
import com.manage.misc.MyResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		String type = (String) request.getParameter("type");
		String operation = (String) request.getParameter("operation");

		System.out.println("type:" + type + "\toperation:" + operation);
		if (type == null || type.trim().equals("")) {
			type = "customer";
		}
		if (operation == null || operation.trim().equals("")) {
			operation = "search";
		}
		switch (type) {
		case "customer":
			searchCustomerLimit(request, response);
			break;
		case "staff":
			switch (operation) {
			case "search":
				searchStaffLimit(request, response);
				break;
			case "del":
				// TODO 级联
				delStaffSingleLine(request, response);
				break;
			case "add":
				// TODO 级联
				addStaffSingleLine(request, response);
				break;
			case "edit":
				editStaffSingleLine(request, response);
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void success(MyResponse<TB_UserInfo> myResponse, ArrayList<TB_UserInfo> list,
			ArrayList<TB_UserInfo> rstList) {
		myResponse.setCode(0);
		myResponse.setData(rstList);
		if (list != null) {
			myResponse.setCount(list.size());
		}
		myResponse.setMsg("");
	}

	private void error(MyResponse<TB_UserInfo> myResponse) {
		myResponse.setCode(-1);
		myResponse.setData(null);
		myResponse.setCount(0);
		myResponse.setMsg("");
	}

	private void delStaffSingleLine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String requestJson = request.getParameter("data");
		String requestJson = request.getParameter("map");
		TB_UserInfo userInfo = new Gson().fromJson(requestJson, TB_UserInfo.class);
		boolean rst = new UserInfoDao().removeStaffSingleLine(userInfo);
		Gson gson = new Gson();
		MyResponse<TB_UserInfo> myResponse = new MyResponse<TB_UserInfo>();
		if (rst) {
			success(myResponse, null, null);
		} else {
			error(myResponse);
		}
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(myResponse));
		out.flush();
		out.close();
	}

	private void searchCustomerLimit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "0");
		int limit = Integer.parseInt(request.getParameter("limit") != null ? request.getParameter("limit") : "0");
		ArrayList<TB_UserInfo> list;
		ArrayList<TB_UserInfo> rstList;
		MyResponse<TB_UserInfo> myResponse = new MyResponse<TB_UserInfo>();
		try {
			list = new UserInfoDao().findAllUserByPetName("顾客");
			rstList = new UserInfoDao().findAllUserByPetName("顾客", (page - 1) * limit, limit);
			success(myResponse, list, rstList);
		} catch (Exception e) {
			error(myResponse);
		}
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(myResponse));
		out.flush();
		out.close();
	}

	private void searchStaffLimit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "0");
		int limit = Integer.parseInt(request.getParameter("limit") != null ? request.getParameter("limit") : "0");
		ArrayList<TB_UserInfo> list;
		ArrayList<TB_UserInfo> rstList;
		MyResponse<TB_UserInfo> myResponse = new MyResponse<TB_UserInfo>();
		try {
			list = new UserInfoDao().findNotCustomer();
			rstList = new UserInfoDao().findNotCustomer((page - 1) * limit, limit);
			success(myResponse, list, rstList);
		} catch (Exception e) {
			error(myResponse);
		}
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(myResponse));
		out.flush();
		out.close();
	}

	private void addStaffSingleLine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestJson = request.getParameter("map");
		TB_UserInfo userInfo = new Gson().fromJson(requestJson, TB_UserInfo.class);
		ArrayList<TB_UserInfo> tb_UserInfos = (ArrayList<TB_UserInfo>) new UserInfoDao().findBy("username",
				userInfo.getUsername(), null, false);
		Gson gson = new Gson();
		MyResponse<TB_UserInfo> myResponse = new MyResponse<TB_UserInfo>();
		if (tb_UserInfos == null || tb_UserInfos.size() == 0) {
			boolean rst = new UserInfoDao().saveStaffSingleLine(userInfo);
			if (rst) {
				success(myResponse, null, null);
			} else {
				error(myResponse);
			}
		} else {
			myResponse.setCode(-2);
			myResponse.setData(null);
			myResponse.setCount(0);
			myResponse.setMsg("");
		}
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(myResponse));
		out.flush();
		out.close();
	}

	/**
	 * @param request
	 * @param response
	 */
	private void editStaffSingleLine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestJson = request.getParameter("map");
		TB_UserInfo userInfo = new Gson().fromJson(requestJson, TB_UserInfo.class);
		MyResponse<TB_UserInfo> myResponse = new MyResponse<>();
		Gson gson = new Gson();
		try {
			boolean flag = new UserInfoDao().updateStaffSingleLine(userInfo);
			if (flag) {
				success(myResponse, null, null);
			}
		} catch (Exception e) {

			// TODO: handle exception
			error(myResponse);
		}
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(myResponse));
		out.flush();
		out.close();
	}
}
