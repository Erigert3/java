package employee_project;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class WorkPosition extends TitleDescriptionAndDate {

	private Employee supervisor;
	private ArrayList<MonthlyWorkPayment> payments;
	
	public WorkPosition(String title, 
						String description) {
		this(title, description, null);
	}
	
	public WorkPosition(String title, 
						String description, 
						GregorianCalendar date) {
		this(title, description, date, null, null);
	}
	
	public WorkPosition(String title, 
						String description, 
						GregorianCalendar date,
						Employee supervisor) {
		this(title, description, date, supervisor, null);
	}
	
	public WorkPosition(String title, 
						String description, 
						GregorianCalendar date,
						Employee supervisor,
						ArrayList<MonthlyWorkPayment> payments) {
		super(title, description, date);
		this.supervisor = supervisor;
		if(payments == null) {
			payments = new ArrayList<>();
		}
		this.payments = new ArrayList<>();
		for(MonthlyWorkPayment payment : payments) {
			addPayment(payment);
		}
	}

	public Employee getSupervisor() {
		return supervisor;
	}
	
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	
	public boolean addPayment(MonthlyWorkPayment payment) {
		if(payment == null) {
			return false;
		}
		payments.add(payment);
		return true;
	}
	
	public int getNumberOfPayments() {
		return payments.size();
	}
	
	public MonthlyWorkPayment getPayment(int index) {
		if(index < 0 || index > payments.size()) {
			return null;
		}
		return payments.get(index);
	}
	
	public GregorianCalendar getDate() {
		return getDateClone();
	}
	
}
