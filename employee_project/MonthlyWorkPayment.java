package employee_project;

import java.util.GregorianCalendar;

public class MonthlyWorkPayment {
	
	public static final short MAX_HOURS = 744;
	
	private GregorianCalendar dateOfPayment;
	private double hours;
	private double paymentPerHour;
	
	public MonthlyWorkPayment(double hours,
			  				  double paymentPerHour) {
		this(hours, paymentPerHour, null);
	}
	
	public MonthlyWorkPayment(double hours, 
							  double paymentPerHour, 
							  GregorianCalendar dateOfPayment) {
		if(hours < 0 || hours > MAX_HOURS) {
			hours = 0;
		}
		if(paymentPerHour < 0) {
			paymentPerHour = 0;
		}
		if(dateOfPayment == null) {
			dateOfPayment = new GregorianCalendar();
		}
		this.hours = hours;
		this.paymentPerHour = paymentPerHour;
		this.dateOfPayment = (GregorianCalendar) dateOfPayment.clone();
	}

	public GregorianCalendar getDateOfPaymentClone() {
		return (GregorianCalendar) dateOfPayment.clone();
	}
	
	public double getHours() {
		return hours;
	}
	
	public double getPaymentPerHour() {
		return paymentPerHour;
	}
	
}
