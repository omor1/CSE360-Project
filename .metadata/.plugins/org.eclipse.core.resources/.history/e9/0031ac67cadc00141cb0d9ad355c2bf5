import java.sql.*;

public class MySQLConnect {
	Connection conn = null;
	public static Connection ConnectDb() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost/student","root","root");
			System.out.println("Connection work!");
			return conn;
	}
}
