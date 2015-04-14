import javax.mail.internet.InternetAddress;

public class Person {

	private String name;
	private final int id; 
	private final InternetAddress email;
	
	private String password; // THIS WILL CHANGE

	public Person(String newName, int newId, InternetAddress newEmail, String newPassword) {
		this.name = newName;
		this.id = newId;
		this.email = newEmail;
		this.password = newPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public InternetAddress getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
