package developingApp;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Employee {

	String name();
	
	String secondName();
	
	int age();
	
	int phoneNumber();
	
	LocalDate dateofEmployment();

	int getId();

	static ArrayList<Employee> initializeEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
