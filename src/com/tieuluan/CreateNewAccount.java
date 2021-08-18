package com.tieuluan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.Database;

/**
 * Servlet implementation class CreateNewAccount
 */
@WebServlet(urlPatterns = {"/CreateNewAccount"})
public class CreateNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = Database.getConnection();
		String sqlString= "insert into login values(?,?)";
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		int i;
		if(email!= null) {
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(sqlString);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, password);
				i= preparedStatement.executeUpdate();
				response.sendRedirect("/TieuLuan/web/Login.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
