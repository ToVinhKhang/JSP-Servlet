package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckedLogin {
	public boolean check(String email, String password) {
		Connection connection = Database.getConnection();
		String sql = "select * from login where email=? and password=?";
		
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) connection.prepareStatement(sql);// đưa vào sql 
			ps.setString(1, email);// chuyền vào 
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				connection.close();
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//bên filter sau khi gọi vào check nó sẽ lấy giá tị email và pass truyền vào trong dấu ? trong sql 
	//rs sẽ thực thi giữ kết quả của ps , rs sẽ chạy trong database khi nào gặp cái giống thì nó dừng và đóng kết nối 
	// trả về true . qua bên filter nếu true thì chạy qua trang admin nếu false thì ở lại 
}
