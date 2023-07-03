package employee_project;

import java.util.GregorianCalendar;
	
public class TitleDescriptionAndDate {
	
	private String title;
	private String description;
	private GregorianCalendar date;
	
	public TitleDescriptionAndDate(String title, 
			   					   String description) {
		this(title, description, null);
	}
	
	public TitleDescriptionAndDate(String title, 
								   String description, 
								   GregorianCalendar date) { 
		this.title = title;
		this.description = description;
		if(date == null) {
			date = new GregorianCalendar();
		}
		this.date = (GregorianCalendar) date.clone();
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public GregorianCalendar getDateClone() {
		return (GregorianCalendar) date.clone();
	}	
	
}
