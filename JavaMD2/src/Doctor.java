import javax.mail.internet.InternetAddress;

public class Doctor extends Person {

	private int threshold;

	public Doctor(String name, int id, InternetAddress email, String password) {
		super(name, id, email, password);
		this.setThreshold(0);
	}

	public Doctor(String name, int id, InternetAddress email, String password,
			int threshold) {
		// TODO Auto-generated constructor stub
		super(name,id,email,password);
		this.setThreshold(threshold);
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
