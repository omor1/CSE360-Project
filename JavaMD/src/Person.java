
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Person {
	
	public enum Gender {
		MALE,
		FEMALE,
		OTHER
	}
	
	private Gender gender;
	private final LocalDate birthDate;
	private String name;
	private final UUID id; //hi
	
	public Person(Gender gender, LocalDate birthDate, String name, UUID id) {
		this.setGender(gender);
		this.birthDate = birthDate;
		this.setName(name);
		this.id = id;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
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
	
	public Period getAge() {
		return Period.between(birthDate, LocalDate.now());
	}

}
