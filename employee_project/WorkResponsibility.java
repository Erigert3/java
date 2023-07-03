package employee_project;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class WorkResponsibility extends TitleDescriptionAndDate {
 
	private GregorianCalendar endDate;
	private ArrayList<WorkTimePeriod> schedule;
	
	public WorkResponsibility(String title, 
							  String description) {
		this(title, description, null, null, null); 
	}
	
	public WorkResponsibility(String title, 
							  String description, 
							  GregorianCalendar endDate) {
		this(title, description, null, endDate, null); 
	}

	public WorkResponsibility(String title, 
							  String description, 
							  GregorianCalendar date, 
							  GregorianCalendar endDate,
							  ArrayList<WorkTimePeriod> schedule) {
		super(title, description, date); 
		if(endDate == null || endDate.before(getDateClone())) {
			endDate = getDateClone();
			endDate.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		this.endDate = endDate;
		if(schedule == null) {
			schedule = new ArrayList<>();
		}
		this.schedule = getCheckedCopyOf(schedule);
	}

	private ArrayList<WorkTimePeriod> 
				getCheckedCopyOf(ArrayList<WorkTimePeriod> schedule) {
		ArrayList<WorkTimePeriod> result = new ArrayList<>(); 
		GregorianCalendar startDate = getDateClone();
		for(WorkTimePeriod workTimePeriod : schedule) { 
			if(workTimePeriod.isBetweenDates(startDate, endDate)) {
				schedule.add(workTimePeriod);
			}
		}
		return result;
	}
	
	public boolean addWorkTimePeriod(WorkTimePeriod workTimePeriod) {
		if(workTimePeriod == null) {
			return false;
		}
		GregorianCalendar startDate = getDateClone();
		GregorianCalendar now = new GregorianCalendar();
		if(workTimePeriod.isBetweenDates(startDate, endDate) &&
		   workTimePeriod.getStartClone().after(now)) {
			schedule.add(workTimePeriod);
			return true;
		}
		return false;
	}
	
	public boolean removeWorkTimePeriod(WorkTimePeriod workTimePeriod) {
		if(workTimePeriod == null) {
			return false;
		}
		GregorianCalendar now = new GregorianCalendar();
		if(workTimePeriod.getStartClone().after(now)) {
			for(int i = 0; i < schedule.size(); i++) { 
				if(schedule.get(i).equals(workTimePeriod)) {
					schedule.remove(i);
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public boolean removeWorkTimePeriod(int index) {
		if(index < 0 || index >= getNumberOfWorkTimePeriods()) {
			return false;
		}
		GregorianCalendar now = new GregorianCalendar();
		if(schedule.get(index).getStartClone().after(now)) {
			schedule.remove(index);
			return true;
		}
		return false;
	}
	
	public int getNumberOfWorkTimePeriods() {
		return schedule.size();
	}
	
	public WorkTimePeriod getWorkTimePeriod(int index) {
		if(index < 0 || index >= getNumberOfWorkTimePeriods()) {
			return null;
		}
		return schedule.get(index);
	}
	
	public GregorianCalendar getEndDateClone() {
		return (GregorianCalendar) endDate.clone();
	}

}
