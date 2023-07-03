package employee_project;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Person {
	
	private final Id SYSTEM_ID;
	private final String NATIONAL_ID;
	private String name;
	private String surname;
	private final Gender GENDER;
	private final GregorianCalendar BIRTHDATE;
	private final ArrayList<String> PHONE_NUMBERS;
	private final ArrayList<Email> EMAILS;
	private Address address;
	
	public Person(String nationalId, 
		          Gender gender, 
		          GregorianCalendar birthdate) {
		this(new Id(), nationalId, "", "", gender, birthdate, null);
	}

	public Person(String nationalId, 
				  String name,
				  String surname,
		          Gender gender, 
		          GregorianCalendar birthdate, 
		          Address address) {
		this(new Id(), nationalId, name, surname, gender, birthdate, address);
	}

	public Person(Id systemId,
				  String nationalId, 
				  String name,
				  String surname,
		          Gender gender, 
		          GregorianCalendar birthdate, 
		          Address address) {
		if(systemId == null) {
			systemId = new Id();
		}
		SYSTEM_ID = systemId;
		if(nationalId == null || (nationalId = nationalId.trim()).isEmpty()) {
			nationalId = NationalIdData.getNext();
		}
		NATIONAL_ID = nationalId;
		if(gender == null) {
			gender = Gender.OTHER;
		}
		GENDER = gender;
		if(birthdate == null || birthdate.after(new GregorianCalendar())) {
			birthdate = new GregorianCalendar();
		}
		BIRTHDATE = (GregorianCalendar) birthdate.clone();	
		this.address = address;
		PHONE_NUMBERS = new ArrayList<>();
		EMAILS = new ArrayList<>();
	}
	
	public int getSystemId(){
		return SYSTEM_ID.getValue();
	}
	
	public String getNationalId() {
		return NATIONAL_ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public Gender getGender() {
		return GENDER;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public GregorianCalendar getBirthdateClone() {
		return (GregorianCalendar) BIRTHDATE.clone();
	}
	
	public boolean addPhoneNumber(String phoneNumber) {
		return false;
	}
	
	public int getNumberOfPhoneNumbers() {
		return PHONE_NUMBERS.size();
	}
	
	public boolean removePhonNumber(String phoneNumber) {
		return false;
	}
	
	public boolean addEmail(Email email) {
		return false;
	}
	
	public int getNumberOfEmails() {
		return EMAILS.size();
	}
	
	public boolean removeEmail(Email email) {
		return false;
	}
	
}
