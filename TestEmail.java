package lessonone;

public class TestEmail {

	public static void main(String[] args) {

		Email email1 = new Email ("rigelsrajku@otr.al");
		
		System.out.println(email1.getEmail());
		
		for (int i = 0; i < 100; i++) {

			Email email2 = new Email ("rigelsrajku", "otr.al");
			
			System.out.println(email2.getEmail());
			
		}
		
	}
	
}
