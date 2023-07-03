package employee_project;

public class GeographicLocation {

	public static final byte MINIMUM_LATITUDE_VALUE = -90;
	public static final byte MAXIMUM_LATITUDE_VALUE = 90;
	public static final short MINIMUM_LONGITUDE_VALUE = -180;
	public static final short MAXIMUM_LONGITUDE_VALUE = 180;
	
	private double latitude;
	private double longitude;
	
	public GeographicLocation(double latitude,
							  double longitude) {
		setLatitude(latitude);
		setLongitude(longitude); 
	}
	
	private void setLongitude(double longitude) {
		if(longitude < MINIMUM_LONGITUDE_VALUE) {
			longitude = MINIMUM_LONGITUDE_VALUE;
		}
		else if(longitude > MAXIMUM_LONGITUDE_VALUE) {
			longitude = MAXIMUM_LONGITUDE_VALUE;
		}
		this.longitude = longitude;
	}

	private void setLatitude(double latitude) {
		if(latitude < MINIMUM_LATITUDE_VALUE) {
			latitude = MINIMUM_LATITUDE_VALUE;
		}
		else if(latitude > MAXIMUM_LATITUDE_VALUE) {
			latitude = MAXIMUM_LATITUDE_VALUE;
		}
		this.latitude = latitude;
	}

	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

}
