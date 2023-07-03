package employee_project;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class WorkTimePeriod { 
	
	private GregorianCalendar start;
	private GregorianCalendar end;
	private ArrayList<String> notes;
	
	public WorkTimePeriod() {
		this(new GregorianCalendar(), null, null);
	}
	
	public WorkTimePeriod(GregorianCalendar start, 
						  GregorianCalendar end) {
		this(start, end, null);
	}
	
	public WorkTimePeriod(GregorianCalendar start, 
						  GregorianCalendar end, 
						  ArrayList<String> notes) {
		if(start == null) {
			start = new GregorianCalendar();
		}
		if(end == null || end.before(start)) {
			end = (GregorianCalendar) start.clone();
			end.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		if(notes == null) {
			notes = new ArrayList<>();
		}
		this.start = start;
		this.end = end;
		this.notes = notes;
	}

	public WorkTimePeriod(WorkTimePeriod workTimePeriod) {
		start = workTimePeriod.start;
		end = workTimePeriod.end;
		notes = new ArrayList<>();
		for(String note : workTimePeriod.notes) {
			notes.add(note);
		}
	}

	public GregorianCalendar getStartClone() {
		return (GregorianCalendar) start.clone();
	}

	public GregorianCalendar getEndClone() {
		return (GregorianCalendar) end.clone();
	}
	
	public void addNote(String note) {
		if(note != null && !notes.contains(note)) {
			notes.add(note);
		}
	}
	
	public int getNumberOfNotes() {
		return notes.size();
	}
	
	public String getNote(int index) {
		if(index < 0 || index >= getNumberOfNotes()) {
			return null;
		}
		return notes.get(index);
	}

	public boolean isBetweenDates(GregorianCalendar startDate, 
								  GregorianCalendar endDate) { 
		return start.after(startDate) && end.before(endDate);
	}
	
	public boolean equals(WorkTimePeriod workTimePeriod) {
		if(this == workTimePeriod) {
			return true;
		}
		if(workTimePeriod == null) {
			return false;
		}
		if(!start.equals(workTimePeriod.start)) {
			return false;
		}
		if(!end.equals(workTimePeriod.end)) {
			return false;
		}
		if(notes.size() != workTimePeriod.notes.size()) {
			return false;
		}
		for(String note : notes) {
			if(!workTimePeriod.notes.contains(note)) {
				return false;
			}
		}
		return true;
	}
 
}
