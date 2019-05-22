package com.manage.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage.bean.TB_AboutUs;
import com.manage.daobase.impl.ChangeNotesDao;

/**
 * Servlet implementation class ChangeNotesServlet
 */
@WebServlet("/ChangeNotesServlet")
public class ChangeNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeNotesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String type = request.getParameter("type");

		if ("changeA".equals(type)) {
			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectA();
			au.setContent(request.getParameter("content"));
//			System.out.println("111cnsss" + au.getName());
//			System.out.println(au.getContent());
			boolean flag = dao.changeA(au);
			if (flag) {
				out.print("<script>");
				out.print("alert('修改成功！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectA';");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('修改失败！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectA';");
				out.print("</script>");
			}
		} else if ("selectA".equals(type)) {
			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectA();
			request.setAttribute("au", au);
//			request.getServletContext().getRequestDispatcher(arg0)
			request.getRequestDispatcher("/view/index/changeNotes.jsp").forward(request, response);

		} else if ("changeB".equals(type)) {
			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectB();
			au.setContent(request.getParameter("content"));
//			System.out.println("111cnsss" + au.getName());
//			System.out.println(au.getContent());
			boolean flag = dao.changeB(au);
			if (flag) {
				out.print("<script>");
				out.print("alert('修改成功！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectB';");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('修改失败！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectB';");
				out.print("</script>");
			}

		} else if ("selectB".equals(type)) {
			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectB();
			request.setAttribute("au", au);
			request.getRequestDispatcher("/view/index/changeNotes.jsp").forward(request, response);

		} else if ("changeC".equals(type)) {

			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectC();
			au.setContent(request.getParameter("content"));
//			System.out.println("111cnsss" + au.getName());
//			System.out.println(au.getContent());
			boolean flag = dao.changeC(au);
			if (flag) {
				out.print("<script>");
				out.print("alert('修改成功！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectC';");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('修改失败！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectC';");
				out.print("</script>");
			}
		} else if ("selectC".equals(type)) {
			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectC();
			request.setAttribute("au", au);
			request.getRequestDispatcher("/view/index/changeNotes.jsp").forward(request, response);

		} else if ("changeD".equals(type)) {
			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectD();
			au.setContent(request.getParameter("content"));
//			System.out.println("111cnsss" + au.getName());
//			System.out.println(au.getContent());
			boolean flag = dao.changeD(au);
			if (flag) {
				out.print("<script>");
				out.print("alert('修改成功！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectD';");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('修改失败！');");
				out.print("window.location='/DevelopManage-master/ChangeNotesServlet?type=selectD';");
				out.print("</script>");
			}

		} else if ("selectD".equals(type)) {

			ChangeNotesDao dao = new ChangeNotesDao();
			TB_AboutUs au = dao.selectD();
			request.setAttribute("au", au);
			request.getRequestDispatcher("/view/index/changeNotes.jsp").forward(request, response);
		}
	}
}
