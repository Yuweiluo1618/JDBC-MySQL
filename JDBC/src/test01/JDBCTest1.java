package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mysql://127.0.0.1:3306/yuweiluo";
			String user = "root";
			String password ="333";
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(statement != null) {
					statement.close();
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
			try {
				if(connection != null) {
					connection.close();
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

}
