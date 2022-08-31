package cop3805;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Geovanie Ruiz
 *
 */
public class MySqlConnection {
	
	public static String username = "root";
	public static String password = "password";
	public static String url = "jdbc:mysql://localhost:3306/test";

	/**
	 * Connect to the test database and get all employees in the Employees table
	 */
	public static void main(String[] args) {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM Employees WHERE NOT lastName LIKE '%Smith%';");

			while (results.next()) {
				System.out.format(
						"%s: %s, %s\n",
						results.getInt("employeeId"),
						results.getString("lastName"),
						results.getString("firstName")
				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}