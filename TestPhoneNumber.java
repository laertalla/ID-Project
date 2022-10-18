package lessonone;

public class TestPhoneNumber {

	public static void main(String[] args) {

		PhoneNumber nr = new PhoneNumber(68, 2020200) ;
		
		System.out.println(PhoneNumber.ALBANIAN_PREFIX);
		System.out.println(nr.getOriginalOperatorNumber());
		System.out.println(nr.getActualOperatorNumber());
		System.out.println(nr.getSimCardNumber());
		
	}
	
}
