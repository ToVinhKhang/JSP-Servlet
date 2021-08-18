package com.tieuluan;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.Database;



/**
 * Servlet implementation class delete
 */
@WebServlet(urlPatterns = {"/delete"})
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = Database.getConnection();
		
		String MaNV= request.getParameter("MaNV");
		String sql="delete from nhanvien where MaNV='"+MaNV+"'";

		int i;
		try {
			/*
			//Statement statement = connection.createStatement();
			//i= statement.executeUpdate("delete from nhanvien where MaNV='"+MaNV+"'");// VÌ  là kiểu String nên phai nằm trong ngoặc kép nên mới cần dùng "'"+MaNV+"'" còn nếu là kiểu int thì MaNV ="+ MaNV
			*/
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			i= preparedStatement.executeUpdate();
			response.sendRedirect("/TieuLuan/web/EmployeeManagement.jsp");
			System.out.println("Data Deleted Successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
