package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yuweiluo", "root", "333");
			conn.setAutoCommit(false);
			String sql = "update t_act set balance = ? where actno = ?";

			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 10000);
			ps.setInt(2, 111);
			int count = ps.executeUpdate();

			ps.setDouble(1, 10000);
			ps.setInt(2, 222);
			count += ps.executeUpdate();

			System.out.println(count == 2 ? "success" : "fail");
			conn.commit();
		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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

		}

	}
}
