package employee_project;

public class Id {
	
	private int value;
	private static int nextValue = 1;
	
	public Id() {
		value = nextValue;
		nextValue++;
	}
	
	public int getValue(){
		return value;
	}
	
}
