package employee_project;

import java.util.ArrayList;

public class Email {

	private String local;
	private String domain;
	
	private static final ArrayList<Email> emails = new ArrayList<Email>();
	
	public Email(String local, String domain) {
		this(String.join("@", local, domain)); 
	}
	
	public Email(String email) {
		if(email == null || (email = email.trim()).isEmpty()) {
			email = "undefined@undefined";
		}
		int indexOfAt = email.indexOf("@");
		if(indexOfAt == -1) {
			email = email + "@undefined";
			indexOfAt = email.indexOf("@");
		} 
		setDomain(email.substring(indexOfAt + 1));
		setLocal(email.substring(0, indexOfAt));
		emails.add(this);
	}

	private void setLocal(String local) {
		String originalLocalValue = local;
		int n = 1;
		while(existLocalOfThisDomain(local)) {
			local = originalLocalValue + n;
			n++;
		}
		this.local = local;
	} 
	
	private boolean existLocalOfThisDomain(String local) { 
		for(Email email : emails) {
			if(email.local.equalsIgnoreCase(local) &&
			   email.domain.equalsIgnoreCase(domain)) {
				return true;
			}
		}
		return false;
	}

	private void setDomain(String domain) { 
		this.domain = domain;
	}
	
	public String getLocal() {
		return local;
	}
	
	public String getDomain() {
		return domain;
	}

}






