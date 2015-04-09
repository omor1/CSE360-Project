import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();

		try {
			db.getConnection();
			db.deleteTable("Patients");
			db.createTable("Patients");
			db.insertData("Adam", "afranc15@gmail.com", "1234");
			db.insertData("Whoever", "whoever@yahoo.com", "5678");
			db.retrieveData("Patients", "afranc15@gmail.com");
		} catch (Exception e) {

		}
	}

}
