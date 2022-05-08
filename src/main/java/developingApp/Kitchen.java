package developingApp;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

	public class Kitchen {

	    Menu menu = Menu.initializeMenu();

	    private static boolean isOpened = false;

	    static ArrayList<Employee> employees = new ArrayList<Employee>();

	    public Kitchen(ArrayList<Employee> emp){
	        this.employees = emp;
	    }

	    private static ArrayList<Employee> CookersImpl = makeCookersArray(employees);

	    public void startKitchen(){
	        isOpened = true;
	        System.out.println("Kitchen is opened");
	    }
	    public void stopKitchen(){
	        isOpened = false;
	        System.out.println("Kitchen is closed");
	    }

	    public static ArrayList<Employee> makeCookersArray(ArrayList<Employee> employees) {
	        return (ArrayList<Employee>) employees.stream()
	                .filter((Predicate<? super Employee>) CookersImpl)
	                .collect(Collectors.toList());
	    }

//	    public double checkNumberOfCookers(){
//	        return switch (makeCookersArray(employees).size()){
//	            case 1 -> decreasedPercentages = 1;
//	            case 2 -> decreasedPercentages = 1.9;
//	            case 3 -> decreasedPercentages = 2.8;
//	            case 4 -> decreasedPercentages = 3.2;
//	            default -> decreasedPercentages = 0;

//	        };
//	    }

	    public static boolean isOpened() {
	        return isOpened;
	    }

	    public static double getDailyRevenue(ArrayList<Order> oldOrders){
	        Double sum = oldOrders.stream()
	                .mapToDouble(x -> x.calculatePrice()).sum();
	        return sum;
	    }

}
