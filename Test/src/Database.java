import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "test";
	
	/** The name of the table we are testing with */
	private String tableName = "JDBC_TEST";

	/** The name of the Connection **/
	private Connection conn = null;
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean getConnection() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return true;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}

	public boolean createTable(String newTableName){
		tableName = newTableName;

		try {
		    String createString =
			        "CREATE TABLE " + this.tableName + " ( " +
			        "ID INT NOT NULL AUTO_INCREMENT, " +
			        "NAME varchar(40) NOT NULL, " +
			        "EMAIL varchar(100) NOT NULL, " +
			        "PASSWORD varchar(100) NOT NULL,"+
			        "PRIMARY KEY (ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
			return true;
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return false;
		}

	}


	public boolean deleteTable(String newTableName){
		tableName = newTableName;
		try {
		    String dropString = "DROP TABLE " + this.tableName;
			this.executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
			return true;
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * INSERT INTO `test`.`Patients` (`NAME`, `EMAIL`, `PASSWORD`) VALUES ('Hey', 'dsds', 'dsds');
	 */
	public void insertData(String newName, String newEmail, String newPassword){
		try {
			this.tableName = "Patients";
			String inputString = "INSERT INTO " + this.dbName + " . " + this.tableName + " (`NAME`, `EMAIL`, `PASSWORD`) "
				+ " VALUES ('" + newName + "', '" + newEmail + "', '" + newPassword + "');";
			System.out.println(inputString);
		
			this.executeUpdate(conn, inputString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * Retrieves Passward and other data
	 * 
	 */
	/*
	public void retrieveData(String newEmail){
			try {
				String retrieveString = "SELECT * FROM " + this.tableName + " WHERE EMAIL = '" + newEmail
				+ "';";
				System.out.println(retrieveString);
				
				this.executeUpdate(conn, retrieveString);
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
*/
}
