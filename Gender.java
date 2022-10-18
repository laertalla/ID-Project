package lessonone;

public class Gender {

	public static final Gender MALE = new Gender("male", 'm');
	public static final Gender FEMALE = new Gender("female", 'f');
	public static final Gender OTHER = new Gender("other", 'o');
	
	private String gender;
	private char symbol;
	
	private Gender(String gender, char symbol) {
		this.gender = gender;
		this.symbol = symbol;
	}
	
	public String getGender() {
		return gender;
	}
	
	public char getSymbol() {
		return symbol;
	}

}
