package developingApp;

import java.util.ArrayList;

public class Restaraunt {

	    static ArrayList<Order> previousOrders = new ArrayList<>();
	    static ArrayList<Order> currentOrders = new ArrayList<>();
	    static ArrayList<Order> orders = Order.initializeOrders();
	    
	    public static void main(String[] args) {

	        Menu menu = Menu.initializeMenu();
	        ArrayList<Employee> employees = null;
			try {
				employees = Employee.initializeEmployees();
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	        ArrayList<Order> onlineOrders = new ArrayList<>();
	        ArrayList<Order> DefaultOrders = new ArrayList<>();

	        onlineOrders = Order.getOnlineOrders(orders);
	        DefaultOrders = Order.getStationaryOrders(orders);

	        currentOrders.addAll(orders);

			mainRestaraunt console = new mainRestaraunt(previousOrders,currentOrders,orders,onlineOrders,DefaultOrders,employees);
	        mainRestaraunt.mainMenu();
	    }

	    private void addTo(final Order order) {
	        orders.add(order);
	        currentOrders.add(order);

	    }



}
