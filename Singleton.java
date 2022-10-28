package lessonone;

public class Singleton {
	
	/***
	 *	Klase qe krijon vetem nje objekt! 
	 **/
	
	private static Singleton object;
	
	private int intValue;
	private double doubleValue;
	private String stringValue;
	
	private Singleton(int intValue, 
					  double doubleValue, 
					  String stringValue) {
		this.intValue = intValue;
		this.doubleValue = doubleValue;
		this.stringValue = stringValue;
	}
	
	public static void createObject(int intValue, 
								    double doubleValue, 
								    String stringValue) {
		if(object == null) { //objekti nuk eshte krijuar akoma
			object = new Singleton(intValue, doubleValue, stringValue);
		}
	}
	
	public static Singleton getObject() {
		return object;
	}
	
	public int getIntValue() {
		return intValue;
	}
	
	public double getDoubleValue() {
		return doubleValue;
	}
	
	public String getStringValue() {
		return stringValue;
	}
	
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

}
