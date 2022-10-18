package lessonone;

public class GeographicLocation { 
	// Klasa eshte immutable 
	public static final byte MIN_LATITUDE = -90;
	public static final byte MAX_LATITUDE = 90;
	public static final short MIN_LONGITUDE = -180;
	public static final short MAX_LONGITUDE = 180;
	
	private double latitude;// - 90 , 90
	private double longitude;// -180 , 180
	
	public GeographicLocation(double latitude, double longitude) {
		if(!isValidLatitude(latitude)) {
			latitude = MIN_LATITUDE;
		}
		if(!isValidLongitude(longitude)) {
			longitude = MIN_LONGITUDE;
		}
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	private static boolean isValidLatitude(double latitude){
		return latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE;
	}
	
	private static boolean isValidLongitude(double longitude){
		return longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
}
