
public class Person {
	
	public enum Gender {
		MALE,
		FEMALE,
		OTHER
	}
	
	private Gender gender;
	private int age;
	
	public Person(Gender gender, int age) {
		this.gender = gender;
		this.age = age;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	

}
