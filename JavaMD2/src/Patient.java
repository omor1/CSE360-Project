import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

import javax.mail.internet.InternetAddress;

public class Patient extends Person {

	public enum Gender {
		MALE, FEMALE, OTHER
	}

	public class MedicalInformation {

		public class Prescription {
			private final String name;
			private final double amount;

			public Prescription(String name, double amount) {
				this.name = name;
				this.amount = amount;
			}

			public String getName() {
				return name;
			}

			public double getAmount() {
				return amount;
			}
		}

		private final List<String> allergies;
		private final List<Prescription> prescriptions;

		public MedicalInformation() {
			this.allergies = new LinkedList<>();
			this.prescriptions = new LinkedList<>();
		}

		public List<String> getAllergies() {
			return allergies;
		}

		public List<Prescription> getPrescriptions() {
			return prescriptions;
		}
	}

	private Gender gender;
	//private final LocalDate birthDate;
	//private double height;
	//private double weight;
	//private final MedicalInformation medicalInformation;
	//private final List<Form> forms;

	public Patient(String name, int id, InternetAddress email, String password) {
		super(name, id, email, password);
		this.setGender(gender);
		//this.birthDate = birthDate;
		//this.setWeight(weight);
		//this.setHeight(height);
		//this.medicalInformation = medicalInformation;
		//this.forms = forms;
	}
	
	//public Patient(String name, int id, InternetAddress email, )

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

	public MedicalInformation getMedicalInformation() {
		return medicalInformation;
	}

	public List<Form> getForms() {
		return forms;
	}

	public Period getAge() {
		return Period.between(this.getBirthDate(), LocalDate.now());
	}

}
