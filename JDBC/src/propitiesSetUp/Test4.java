package propitiesSetUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Test4 {

	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("propitiesSetUp.jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");

		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			System.out.print(connection);
			statement = connection.createStatement();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}

}
