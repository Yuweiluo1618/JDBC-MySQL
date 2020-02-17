package preparedCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedCRUD {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "333");
			//insert
			/*String sql = "insert into departments(dept_no,dept_name) values('d010',?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "Balck");
			int count = ps.executeUpdate();
			System.out.println(count);*/
			//update
			/*String sql = "update departments set dept_name = ? where dept_no = 'd010'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "white");
			ps.executeUpdate();*/
			//delete
			String sql = "delete from departments where dept_no = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "d010");
			ps.executeUpdate();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
