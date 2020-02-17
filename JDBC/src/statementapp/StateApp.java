package statementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StateApp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("desc or asc ?");
		String keyWord = s.nextLine();
		
		//JDBC
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "333");
			stmt = conn.createStatement();
			String sql = "select * from departments order by dept_name " + keyWord;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String key = rs.getString(1);
				String dept = rs.getString(2);
				System.out.println(key+","+dept);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
