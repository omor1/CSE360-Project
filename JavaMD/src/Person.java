import java.util.UUID;
import javax.mail.internet.InternetAddress;

public class Person {

	private String name;
	private final UUID id;
	private final InternetAddress email;
	
	private final String password; // THIS WILL CHANGE

	public Person(String name, UUID id, InternetAddress email, String password) {
		this.setName(name);
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public InternetAddress getEmail() {
		return email;
	}

}
