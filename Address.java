package lessonone;

import java.util.Objects;

public class Address {
	
	private static final short MIN_ZIP_CODE = 1_000;
	private static final short MAX_ZIP_CODE = 9_999;
	/**
	 * Do  ruhen objekte adrese me permbajtje 
	 * 		emer shteti						e pandryshueshme
	 * 		emer qyteti						e pandryshueshme
	 * 		emer rruge						e ndryshueshme
	 * 		emer godine						e ndryshueshme
	 * 		numri i apartamentit			e ndryshueshme
	 * 		vendndodhje gjeografike			e pandryshueshme
	 * 		kodi zip						e ndryshueshme
	 ***/

	
	private String state;
	private String city;
	private String street;
	private String building;
	private int apartmentNumber;
	private GeographicLocation location;
	private short zipCode;
	
	public Address(String state,
			       String city,
			       GeographicLocation location) {
		this(state, city, null, null, 0, location, 0);
	}
	
	public Address(String state,
				   String city,
				   String street,
				   String building,
				   GeographicLocation location,
				   int zipCode) {
		this(state, city, street, building, 0, location, zipCode);
	}
	
	public Address(String state,
				   String city,
				   String street,
				   String building,
				   int apartmentNumber,
				   GeographicLocation location,
				   int zipCode) { 
		if(state == null || (state = state.trim()).isEmpty()) {
			state = "undefined";
		}
		if(city == null || (city = city.trim()).isEmpty()) {
			city = "undefinded";
		}
		if(street == null || (street = street.trim()).isEmpty()) {
			street = "undefinded";
		}
		if(building == null || (building = building.trim()).isEmpty()) {
			building = "undefinded";
		}
		if(location == null) {
			location = new GeographicLocation(GeographicLocation.MIN_LATITUDE, GeographicLocation.MIN_LONGITUDE);
		}
		if(zipCode < MIN_ZIP_CODE || zipCode > MAX_ZIP_CODE) {
			zipCode = MIN_ZIP_CODE;
		}
		this.state = state;
		this.city = city;
		this.street = street;
		this.building = building;
		this.apartmentNumber = apartmentNumber;
		this.location = location;
		this.zipCode = (short) zipCode;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getBuilding() {
		return building;
	}
	
	public void setBuilding(String building) {
		this.building = building;
	}
	
	public int getApartamentNumber() {
		return apartmentNumber;
	}
	
	public void setApartamentNumber(int apartamentNumber) {
		this.apartmentNumber = apartamentNumber;
	}
	
	public GeographicLocation getLocation() {
		return location;
	}
	
	public short getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(short zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "lessonone.Address ["
				+ "state=" + state 
				+ ", city=" + city 
				+ ", street=" + street 
				+ ", building=" + building
				+ ", apartmentNumber=" + apartmentNumber 
				+ ", location=" + location 
				+ ", zipCode=" + zipCode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartmentNumber, building, city, location, state, street, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return apartmentNumber == other.apartmentNumber &&
			   Objects.equals(building, other.building) && 
			   Objects.equals(city, other.city) && 
			   Objects.equals(location, other.location) && 
			   Objects.equals(state, other.state) && 
			   Objects.equals(street, other.street) && 
			   zipCode == other.zipCode;
	}
	
	
	
}
