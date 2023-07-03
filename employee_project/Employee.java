package employee_project;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Employee extends Person {
	
	private ArrayList<WorkPosition> workPositions;
	private ArrayList<Certificate> certificates;
	private ArrayList<EmployeeEvaluation> evaluations;
	private ArrayList<WorkResponsibility> workResponsibilities;
	private Address officeAddress;
	
	public Employee(Id systemId, 
					String nationalId,	
					String name, 
					String surname, 
					Gender gender,
					GregorianCalendar birthdate, 
					Address address,
					WorkPosition workPosition,
					Address officeAddress) {
		super(systemId, nationalId, name, surname, gender, birthdate, address);
		workPositions = new ArrayList<>();
		if(workPosition == null) {
			workPosition = new WorkPosition("Intern", "");
		}
		workPositions.add(workPosition);
		certificates = new ArrayList<>();
		evaluations = new ArrayList<>();
		workResponsibilities = new ArrayList<>();
		this.officeAddress = officeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public boolean addWorkPosition(WorkPosition workPosition) {
		return false;
	}
	
	public WorkPosition getWorkPosition() {
		return workPositions.get(getNumberOfWorkPositions() - 1);
	}

	public int getNumberOfWorkPositions() {
		return workPositions.size();
	}
	
	public WorkPosition getWorkPosition(int index) {
		if(index < 0 || index >= getNumberOfWorkPositions()) {
			return null;
		}
		return workPositions.get(index);
	}
	
	public boolean addCertificate(Certificate certificate) {
		return false;
	}
	
	public int getNumberOfCertificates() {
		return certificates.size();
	}
	
	public Certificate getCertificate(int index) {
		if(index < 0 || index >= getNumberOfCertificates()) {
			return null;
		}
		return certificates.get(index);
	}
	
	public boolean addEvaluation(EmployeeEvaluation evaluation) {
		return false;
	}
	
	public int getNumberOfEvaluations() {
		return evaluations.size();
	}
	
	public EmployeeEvaluation getEvaluation(int index) {
		if(index < 0 || index >= getNumberOfEvaluations()) {
			return null;
		}
		return evaluations.get(index);
	}
	
	public boolean addWorkResponsibilities(WorkResponsibility workResponsibility) {
		return false;
	}

	public boolean removeWorkResponsibilities(WorkResponsibility workResponsibility) {
		return false;
	}

	public boolean removeWorkResponsibilities(int index) {
		return false;
	}
	
	public int getNumberOfWorkResponsibilities() {
		return workResponsibilities.size();
	}
	
	public WorkResponsibility getWorkResponsibilities(int index) {
		if(index < 0 || index >= getNumberOfWorkResponsibilities()) {
			return null;
		}
		return workResponsibilities.get(index);
	}
	
}
