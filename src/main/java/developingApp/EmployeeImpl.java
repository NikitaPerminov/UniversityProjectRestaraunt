package developingApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeImpl implements Employee{
	
	 private String name;
	 private String secondName;
	 private int age;
	 private int phoneNumber;
	 private LocalDate dateOfEmployment;
	 private int id;
	 private static final AtomicInteger count = new AtomicInteger(0);
	 
	 
	 @Override
	    public String toString() {
	        return "Employee{" +
	                "name='" + name + '\'' +
	                ", secondName='" + secondName + '\'' +
	                ", age=" + age +
	                ", phoneNumber=" + phoneNumber +
	                ", dateOfEmployment=" + dateOfEmployment +
	                '}';
	 }
	 
	 static ArrayList<Employee> initializeEmployees(){
		 
		 ArrayList<Employee> emp = new ArrayList<>();
	     WaiterImpl alexey = new WaiterImpl("Alexey", "Mazurin", 27, 22_2232_31, LocalDate.parse("2012-02-05"));
	     CookersImpl josh = new CookersImpl("Josh", "Navario", 20, 13_46_789, LocalDate.parse("2020-07-06"));
	     CookersImpl taras = new CookersImpl("Taras", "Kwadrolenko", 58, 123_456_782, LocalDate.parse("2014-01-20"));
	     SupplierImpl sofia = new SupplierImpl("Sofia", "Shulga", 22, 119_023_111, LocalDate.parse("2022-02-24"));
	     
	     emp.add((Employee) alexey);
	     emp.add((Employee) josh);
	     emp.add((Employee) taras);
	     emp.add((Employee) sofia);

	     return emp;
	     
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String secondName() {
		return secondName;
	}

	@Override
	public int age() {
		return age;
	}

	@Override
	public int phoneNumber() {
		return phoneNumber;
	}

	@Override
	public LocalDate dateofEmployment() {
		return dateOfEmployment;
	}
	
	public  boolean isCooker(){
        return this.getClass().getName().equals("Cooker");
    }
	
	 public int getId() {
	    return id;
	}

	 public void setId(int id) {
	    this.id = id;
	}

	public static int incrementID(){
        int id = count.incrementAndGet();
        return id;
    }
	
	
	
}
