import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		Patient p = new Patient(null, 0, null, null, null, 0, 0, null, null, null);
		p.setName("Adam");
		try {
			db.getConnection(); 
			List<Form> l = db.retrieveListofForms(p, "Pending");
			for(int ii = 0; ii < l.size(); ii++){
				System.out.println(l.get(ii).toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
