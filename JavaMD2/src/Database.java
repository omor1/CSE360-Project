import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Database {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/**
	 * The name of the database we are testing with (this default is installed
	 * with MySQL)
	 */
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

		conn = DriverManager.getConnection("jdbc:mysql://" + this.serverName
				+ ":" + this.portNumber + "/" + this.dbName, connectionProps);

		return true;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException
	 *             If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command)
			throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it
											// fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public boolean createTable(String newTableName) {
		tableName = newTableName;

		try {
			String createString = "CREATE TABLE " + this.tableName + " ( "
					+ "ID INT NOT NULL AUTO_INCREMENT, "
					+ "NAME varchar(40) NOT NULL, "
					+ "EMAIL varchar(100) NOT NULL, "
					+ "PASSWORD varchar(100) NOT NULL," + "PRIMARY KEY (ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
			return true;
		} catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return false;
		}

	}


	public boolean deleteTable(String newTableName) throws SQLException {

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
	 * Create form in Database
	 * 
	 * INSERT INTO `test`.`Forms` (`Patient`, `Doctor`, `Priority`, `Comments`, `Nausea`, `Pain`, `Fatigue`, `Anxiety`, `ShortnessOfBreath`) 
	 * VALUES ('a', 's', '4', 'd', '1', '3', '3', '3', '3');

	 */
	
	public void createForm(Form f1) throws SQLException {
		// TODO Auto-generated method stub
		this.tableName = "Forms";
		String createForm = "INSERT INTO " + this.dbName + " . "
				+ this.tableName + " (`Patient`, `Priority`, `Comments`, `Nausea`, `Pain`, `Fatigue`, `Anxiety`, `ShortnessOfBreath`, `Status`) " 
				+ "VALUES ('" + f1.getPatient() + "', '" + f1.getPriority() + "', '" +  f1.getComments() + "', '" + f1.getPain()
				+ "', '" + f1.getPain() + "', '" + f1.getFatigue() + "', '" + f1.getAnxiety() + "', '" +f1.getShortnessOfBreath() + "', '" 
				+ f1.getStatus() + "');";
		System.out.println(createForm);
		this.executeUpdate(conn, createForm);
	}
	/*
	 * Update form with diagnose and doctor
	 * UPDATE `test`.`Forms` SET `Doctor`='Anybody', `Diagnose`='I sent a prescibtion to the pharmacy' WHERE `idForms`='5';
	 */
	
	public void updateForm(Form f1) throws SQLException{
		this.tableName = "Forms";
		String updateString = "UPDATE " + this.dbName + " . "
				+ this.tableName + " SET `Doctor`='" + f1.getDoctor() + "', `Diagnose`='"+ f1.getDiagnosis() 
				+ "', `Status`='" + f1.getStatus()
				+ "' WHERE `idForms`='" + f1.getId() + "';";
		System.out.println(updateString);
		this.executeUpdate(conn, updateString);
	}
	
	public List<Form> retrieveListofForms(Person user, String status) throws SQLException{
		String retrieveString;
		
		if(user instanceof Doctor){
			if(status.equals("Completed")){
				retrieveString = "SELECT * FROM test . Forms WHERE Doctor = '" + user.getName() + "' AND Status = '" + status + "';";
				System.out.println(retrieveString);
			}else{
				retrieveString = "SELECT * FROM test . Forms WHERE Priority > '" + ((Doctor) user).getThreshold() + "' AND Status = '" + status + "';";
				System.out.println(retrieveString);
			}
		}else{
			retrieveString = "SELECT * FROM test . Forms WHERE Patient = '" + user.getName() + "' AND Status = '" + status + "';";
			System.out.println(retrieveString);
		}
		
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(retrieveString);
		List<Form> l1 = new ArrayList<Form>();
		while(rs.next()){
			//(int newid, int i, int j, int k, int l,int m, String comments, String diagnosis, String status, String patient, String doctor)
			Form F = new Form(rs.getInt("idForms"), rs.getInt("Nausea"), rs.getInt("Pain"), rs.getInt("Fatigue"), rs.getInt("Anxiety"), rs.getInt("ShortnessOfBreath"), 
					rs.getString("Comments"), rs.getString("Diagnose"), rs.getString("Status"), rs.getString("Patient"), rs.getString("Doctor"));
			l1.add(F);
	
		}
		
		return l1;
		
	}
	
	public Form retrieveNextPatient(Person user) throws SQLException {
		String retrieveString = "SELECT * FROM test . Forms WHERE Priority > '" + ((Doctor) user).getThreshold() + "' AND Status = 'Pending';";
		System.out.println(retrieveString);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(retrieveString);
		if(rs.next()){
			//(int newid, int i, int j, int k, int l,int m, String comments, String diagnosis, String status, String patient, String doctor)
			Form F = new Form(rs.getInt("idForms"), rs.getInt("Nausea"), rs.getInt("Pain"), rs.getInt("Fatigue"), rs.getInt("Anxiety"), rs.getInt("ShortnessOfBreath"), 
					rs.getString("Comments"), rs.getString("Diagnose"), rs.getString("Status"), rs.getString("Patient"), rs.getString("Doctor"));
			System.out.println(F.toString());
			return F;
		}else{
			return null;
		}
	}
	
	public Form retrieveForm(int id){
		return null;
		
	}
	
	/*
	 * INSERT INTO `test`.`Patients` (`NAME`, `EMAIL`, `PASSWORD`) VALUES
	 * ('Hey', 'dsds', 'dsds');
	 */
	public void insertData(String newName, String newEmail, String newPassword) throws SQLException {
		
			this.tableName = "Patients";
			String inputString = "INSERT INTO " + this.dbName + " . "
					+ this.tableName + " (`NAME`, `EMAIL`, `PASSWORD`) "
					+ " VALUES ('" + newName + "', '" + newEmail + "', '"
					+ newPassword + "');";
			System.out.println(inputString);

			this.executeUpdate(conn, inputString);


	}

	/*

	 * Update Database with person
	 *UPDATE `test`.`Patients` SET `NAME`='Ddav', `EMAIL`='da' WHERE `ID`='1';
	 *UPDATE 'test'.'Doctors' SET `NAME`='Ddav', `EMAIL`='da', 'Threshold'='3' WHERE `ID`='1'
	 */
	public void updatePerson(Person user) throws SQLException{
		String updateString;
		
		if(user instanceof Patient){			
			this.tableName = "Patients";
			updateString = "UPDATE " + this.dbName + " . "
					+ this.tableName + " SET `NAME`='" + user.getName() + "', `PASSWORD`='" + user.getPassword() + "' WHERE `ID`='"
					+ user.getId() + "';";
		}else{
			this.tableName = "Doctors";
			Doctor temp = (Doctor) user;
			updateString = "UPDATE " + this.dbName + " . "
				+ this.tableName + " SET `NAME`='" + temp.getName() + "', `PASSWORD`='" + temp.getPassword() + "', `Threshold`='"+ temp.getThreshold() + "' WHERE `ID`='"
				+ user.getId() + "';";
		}
		
		
		System.out.println(updateString);

		this.executeUpdate(conn, updateString);
	}
	/*
	 * Retrieves Password and other data
	 */
	
	public Person retrievePerson(String newTableName, String username, String password) throws SQLException, AddressException {
		String retrieveString = "SELECT * FROM test . " + newTableName
				+ " WHERE email = '" + username + "' AND password = '" + password + "';";
		System.out.println(retrieveString);

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(retrieveString);
		if (rs.next()) {
			int id;
			String name;
			InternetAddress email;
			
			if(newTableName.equals("Doctors")){
				id = rs.getInt("ID");
				name = rs.getString("NAME");
				email = new InternetAddress(rs.getString("EMAIL"));
				int threshold = rs.getInt("Threshold");
				Person temp = new Doctor(name, id, email, password, threshold);
				return temp;
			}else{
				id = rs.getInt("ID");
				name = rs.getString("NAME");
				email = new InternetAddress(rs.getString("EMAIL"));
				Person temp = new Person(name, id, email, password);
				return temp;
			}
			
		}else {
			return null;
		}

	}

	public Person searchEmail(String email) throws SQLException{
		String str = "SELECT * FROM test . Patients WHERE email = '" + email + "';";
		System.out.println(str);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(str);
		if(rs.next()){
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			String pw = rs.getString("PASSWORD");
			InternetAddress e = null;
			try {
				e = new InternetAddress(email);
			} catch (AddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//this is where the problem is -DS
			Person r = new Patient(name, id, e, pw);
			return r;
		}else{
				
			System.out.println("Not in Patients table");
			String str2 = "SELECT * FROM test . Doctors WHERE email = '" + email + "';";
			System.out.println(str2);
			Statement st2 = conn.createStatement();
			ResultSet rs2 = st2.executeQuery(str2);
			if(rs2.next()){
				int id = rs2.getInt("ID");
				String name = rs2.getString("NAME");				
				int threshold = rs2.getInt("Threshold");
				String pw = rs2.getString("PASSWORD");
				InternetAddress e = null;
				try {
					e = new InternetAddress(email);
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Person t = new Doctor(name, id, e, pw, threshold);
				return t;
			}else{
				return null;
			}
		}
	}

	
}
