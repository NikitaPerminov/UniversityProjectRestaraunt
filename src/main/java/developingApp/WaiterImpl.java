package developingApp;

import java.time.LocalDate;

public class WaiterImpl implements Waiter{
	
	private String name;
	private String secondName;
	private int age;
	private int phoneNumber;
	private LocalDate dateOfEmployment;

	public WaiterImpl(String string, String string2, int i, int j, LocalDate parse) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String secondName() {
		// TODO Auto-generated method stub
		return secondName;
	}

	@Override
	public int age() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public int phoneNumber() {
		// TODO Auto-generated method stub
		return phoneNumber;
	}

	@Override
	public LocalDate dateOfEmployment() {
		// TODO Auto-generated method stub
		return dateOfEmployment;
	}

}
