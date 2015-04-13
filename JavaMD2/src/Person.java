import java.util.UUID;

import javax.mail.internet.InternetAddress;

public class Person {

	private String name;
	private final UUID id; 
	private final InternetAddress email;
	
	private String password; // THIS WILL CHANGE

<<<<<<< HEAD
	public Person(String newName, int newId, InternetAddress newEmail, String newPassword) {
		this.name = newName;
		this.id = newId;
		this.email = newEmail;
		this.password = newPassword;
=======
	public Person(String name, UUID id2, InternetAddress email, String password) {
		this.setName(name);
		this.id = id2;
		this.email = email;
		this.password = password;
>>>>>>> master
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
=======
	public UUID getId() {
>>>>>>> master
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
