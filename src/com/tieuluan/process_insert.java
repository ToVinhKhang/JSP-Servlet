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
 * Servlet implementation class process_insert
 */
@WebServlet("/process_insert")
public class process_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = Database.getConnection();
		String sqlString= "insert into nhanvien values(?,?,?,?,?)";
		String MaNV= request.getParameter("MaNV");
		String tenNV= request.getParameter("tenNV");
		String ChucVu= request.getParameter("ChucVu");
		String taikhoan= request.getParameter("taikhoan");
		String matkhau= request.getParameter("matkhau");
		int i;
		if(MaNV!=null)
		try {
			PreparedStatement pt= connection.prepareStatement(sqlString);
			pt.setString(1, MaNV);
			pt.setString(2, tenNV);
			pt.setString(3, ChucVu);
			pt.setString(4, taikhoan);
			pt.setString(5, matkhau);
			i=pt.executeUpdate();
			response.sendRedirect("/TieuLuan/web/EmployeeManagement.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
