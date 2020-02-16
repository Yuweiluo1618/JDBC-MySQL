package sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// this program improve login interface: solving SQL injection

public class SQLInjection {

	public static void main(String[] args) {
		// initialize user interface
		Map<String, String> userLogininfo = initUI();
		// verified username and password
		boolean loginSuccess = login(userLogininfo);
		System.out.println(loginSuccess ? "login success" : "login fail");

	}

	/*
	 * user login condition
	 * 
	 * @return true: success false: fail
	 */
	private static boolean login(Map<String, String> userLogininfo) {
		boolean loginSuccess = false;
		String loginName = userLogininfo.get("loginName");
		String loginPWD = userLogininfo.get("loginPWD");
		// JDBC
		Connection conn = null;
		PreparedStatement ps = null;//use PreparedStatement
		ResultSet res = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yuweiluo", "root", "333");
			String sql = "select * from t_user where loginname = ? and loginPWD = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginName);
			ps.setString(2, loginPWD);
			res = ps.executeQuery();
			if(res.next()) {
				loginSuccess = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (res != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return loginSuccess;
	}

	/*
	 * initialize UI and return username and password information
	 */

	private static Map<String, String> initUI() {
		Scanner s = new Scanner(System.in);
		System.out.print("username :");
		String loginName = s.nextLine();
		
		System.out.print("password :");
		String loginPWD = s.nextLine();
		
		Map<String, String> userLogininfo = new HashMap<String, String>();
		userLogininfo.put("loginName", loginName);
		userLogininfo.put("loginPWD", loginPWD);
		return userLogininfo;
	}

}
