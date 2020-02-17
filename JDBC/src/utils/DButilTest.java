package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DButilTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			String sql = "select dept_name from departments where dept_no like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "d%");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.close(conn, ps, rs);
		}
	}

}
