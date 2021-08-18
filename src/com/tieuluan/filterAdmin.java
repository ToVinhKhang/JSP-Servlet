package com.tieuluan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.CheckedLogin;
import com.database.Database;

/**
 * Servlet Filter implementation class filterAdmin
 */

@WebFilter(urlPatterns = {"/web/adminPage.jsp","/web/EmployeeManagement.jsp","/web/Insert.jsp","/web/update.jsp"})
//@WebFilter(urlPatterns = { "/web/adminPage.jsp" })// filter ko ko càn phải có tên của thư mục chi cần đường dẫn bên trong ( ko tính thư mục cùng cấp)
public class filterAdmin implements Filter {

	public filterAdmin() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		

		HttpServletRequest req = (HttpServletRequest) request;

		HttpServletResponse res = (HttpServletResponse) response;

		//System.out.print("đã đi qua session");
		// nếu chưa đăng nhập lần nào ==> ko có session sẽ xuống else để thực hiên đăng
		// nhập lần 1
		HttpSession httpSession = req.getSession();
		Object object = httpSession.getAttribute("email"); // hình như nó chết đoạn này
		if (object != null) {
			chain.doFilter(request, response);
		} else {

			//String action = request.getParameter("action");

			// if (email!=null && password!=null && email.equals("thinh@") &&
			// password.equals("123456")) {
			//if (action.equals("login")) {
				String email = request.getParameter("email");
				String password = request.getParameter("pwd");
				CheckedLogin temp = new CheckedLogin();
				boolean isLogin = temp.check(email, password);
				// if (email!=null && password!=null && isLogin==true) {
				if (isLogin == true && email!=null && password!=null ) {
					httpSession.setAttribute("email", email);
					chain.doFilter(request, response);
				} else
					res.sendRedirect("/TieuLuan/web/Login.jsp");
			//} else request.getRequestDispatcher("/TieuLuan/web/Login.jsp").forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
