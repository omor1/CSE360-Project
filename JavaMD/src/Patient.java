import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import javax.mail.internet.InternetAddress;

public class Patient extends Person {
	
	public enum Gender {
		MALE,
		FEMALE,
		OTHER
	}
	
	private Gender gender;
	private final LocalDate birthDate;
	private double height;
	private double weight;
	
	public Patient(String name, UUID id, InternetAddress email, Gender gender, LocalDate birthDate, double height, double weight) {
		super(name, id, email);
		this.setGender(gender);
		this.birthDate = birthDate;
		this.setWeight(weight);
		this.setHeight(height);
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Period getAge() {
		return Period.between(this.getBirthDate(), LocalDate.now());
	}

}
