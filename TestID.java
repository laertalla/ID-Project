package lessonone;

public class TestID {

	public static void main(String[] args) {
		
		Id id1 = new Id();
		
		/***
		 *	Konstruktori default ekziston paraprakisht,
		 *	dhe eshte aty deri kur ndertohet ndonje 
		 *	konstruktor tjeter.
		 *	Konstruktori default ka formen
		 *
		 *		public EmerKlase(){}
		 *
		 *	Konstruktori sherben per te krijuar
		 *	objekte te klases.
		 *	Si psh:
		 *
		 *		String s = new String("hello");
		 **/
		
		
		System.out.println(id1.getValue());
		 
		Id id2 = new Id();
		System.out.println(id2.getValue());
		
	}
	
}
