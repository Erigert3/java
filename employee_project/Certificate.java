package employee_project;

import java.util.GregorianCalendar;

public class Certificate extends TitleDescriptionAndDate {

	private String authority;
	
	public Certificate(String title, String description, String authority) {
		this(title, description, null, authority);
	}

	public Certificate(String title, 
					   String description, 
					   GregorianCalendar date,
					   String authority) {
		super(title, description, date);
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}
	
}
