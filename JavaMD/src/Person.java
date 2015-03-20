
import java.util.UUID;
import javax.mail.internet.InternetAddress;

public class Person {
	

	private String name;
	private final UUID id;
	private final InternetAddress email;
	
	public Person(String name, UUID id, InternetAddress email) {
		this.setName(name);
		this.id = id;
		this.email = email;
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
