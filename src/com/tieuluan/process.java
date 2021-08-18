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
 * Servlet implementation class process
 */
@WebServlet(urlPatterns = {"/process"})
public class process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = Database.getConnection();
		String MaNV = request.getParameter("MaNV");
		String tenNV = request.getParameter("tenNV");
		String ChucVu= request.getParameter("ChucVu");
		String taikhoan= request.getParameter("taikhoan");
		String matkhau= request.getParameter("matkhau");
		String sql="update nhanvien set MaNV=?, tenNV=?,ChucVu=?,taikhoan=?,matkhau=? where MaNV='"+MaNV+"'";
		
			try {
				PreparedStatement pt = connection.prepareStatement(sql);
				pt.setString(1, MaNV);
				pt.setString(2, tenNV);
				pt.setString(3, ChucVu);
				pt.setString(4, taikhoan);
				pt.setString(5, matkhau);
				int i =pt.executeUpdate();
				if(i>0) {
					System.out.print("data updated successfully!");
				}
				else {
					System.out.print("data upldate false");
				}
				response.sendRedirect("/TieuLuan/web/EmployeeManagement.jsp");
			} catch (SQLException e) {
				e.printStackTrace();			
		}
			
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

	

}
