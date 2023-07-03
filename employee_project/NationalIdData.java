package employee_project;

import java.util.ArrayList;

public class NationalIdData {
	
	private static final ArrayList<String> nationalIds = new ArrayList<>();

	public static boolean exists(String nationalId) {
		return nationalIds.contains(nationalId);
	}
	
	public static void insert(String nationalId) {
		nationalIds.add(nationalId);
	}

	public static String getNext() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
