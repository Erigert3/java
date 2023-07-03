package employee_project;

public class Address {

	private final String STATE;
	private final String CITY;
	private String street;
	private String building;
	private String buildingEntrance;
	private String unitId;
	private final int ZIP_CODE;
	private final GeographicLocation LOCATION;
	 
	public Address(String state, 
				   String city,  
				   int zipCode, 
				   GeographicLocation location) {
		this(state, city, "", "", "", "", zipCode, location);
	}
	
	public Address(String state, 
				   String city, 
				   String street, 
				   String building,
				   int zipCode, 
				   GeographicLocation location) {
		this(state, city, street, building, "", "", zipCode, location);
	}
	
	public Address(String state, 
				   String city, 
				   String street, 
				   String building, 
				   String buildingEntrance,
				   String unitId,
				   int zipCode, 
				   GeographicLocation location) {
		STATE = state;
		CITY = city;
		this.street = street;
		this.building = building;
		this.buildingEntrance = buildingEntrance;
		this.unitId = unitId;
		ZIP_CODE = zipCode;
		LOCATION = location;
	}

	public GeographicLocation getLocation() {
		return LOCATION;
	}
	
	public String getState() {
		return STATE;
	}
	
	public String getCity() {
		return CITY;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getBuilding() {
		return building;
	}
	
	public String getBuildingEntrance() {
		return buildingEntrance;
	}
	
	public String getUnitId() {
		return unitId;
	}
	
	public int getZipCode() {
		return ZIP_CODE;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setBuilding(String building) {
		this.building = building;
	}
	
	public void setBuildingEntrance(String buildingEntrance) {
		this.buildingEntrance = buildingEntrance;
	}
	
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	public String getAddressAsString() {
		StringBuilder sb = new StringBuilder();
		if(STATE != null && !STATE.isEmpty()) {
			sb.append(STATE);
		}
		if(CITY != null && !CITY.isEmpty()) {
			if(sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(CITY);
		}
		if(street != null && !street.isEmpty()) {
			if(sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(street);
		}
		if(building != null && !building.isEmpty()) {
			if(sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(building);
		}
		if(buildingEntrance != null && !buildingEntrance.isEmpty()) {
			if(sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(buildingEntrance);
		}
		if(unitId != null && !unitId.isEmpty()) {
			if(sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(unitId);
		}
		if(ZIP_CODE != 0) {
			if(sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(ZIP_CODE);
		}
		if(LOCATION != null) {
			if(sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(LOCATION.getLatitude() + " " +
					  LOCATION.getLongitude());
		} 
		return sb.toString();
	}
	
}
