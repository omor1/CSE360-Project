

import javax.mail.internet.InternetAddress;

public class Doctor extends Person {

	private int threshold;

	public Doctor(String name, int id, InternetAddress email, String password) {
		super(name, id, email, password);
		this.setThreshold(0);
	}

	public Doctor(String name, int id, InternetAddress email, String password,
			int threshold2) {
		// TODO Auto-generated constructor stub
		super(name,id,email,password);
		this.threshold = threshold2;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
