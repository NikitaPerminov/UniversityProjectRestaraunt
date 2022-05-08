package developingApp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public abstract class Order extends ArrayList<Dishes> {

    private static final long serialVersionUID = 1L;
	private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private boolean isOnline;
    private boolean isRealised = false;

    public Order(boolean isOnline) {
        id = incrementID();
        this.isOnline = isOnline;
    }

    public double calculatePrice(){
        return this.stream()
                .filter(Dishes::isAvailable)
                .mapToDouble(Dishes::getPrice)
                .sum();

    }

    public int getId() {
        return id;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public static int incrementID(){
        int id = count.incrementAndGet();
        return id;
    }

    public void deleteById(){
        Restaraunt.currentOrders
                .removeIf(x -> x.getId() == this.getId());
    }

    public void showPrice(ArrayList<Dishes> dishesOnOrder){
        System.out.println( calculatePrice());
    }

    public static void showOrders (ArrayList<Order> orders) {
        orders.forEach(System.out::println);
    }

    public static void showOrderIds (ArrayList<Order> orders) {
        orders.stream().map(Order::getId).forEach(System.out::println);
    }

    public boolean isRealised() {
        return isRealised;
    }

    public void startMakingOrder(){
        System.out.println("# Started making an order: " + getId());
        System.out.println(isOnline ? "# Online Order" : "# Stationary Order");
            this.stream()
                    .forEach(this::isAvailableIfNotThrowException);
        System.out.println("$ Final Price is: " + this.calculatePrice() + "\n# Finished making an order: "+ getId() + "\n -------------------------------");
        Restaraunt.previousOrders.add(this);
        deleteById();


    }

    private void isAvailableIfNotThrowException(Dishes x) {
        if (x.isAvailable())
        {
            x.startMakingDish();
    }
        else{
            x.skip();
            try {
                System.out.println("!!!Order with not available dish !!!");
                throw new UnavaliableError("Dish: " + x.getName() + " is not available");
            } catch (UnavaliableError e) {
            }
        }
    }


    public static ArrayList<Order> initializeOrders(){
        Menu menu = Menu.initializeMenu();
        ArrayList<Order> orders = new ArrayList<>();

        DefaultOrders firstOrder = new DefaultOrders(null, false);
        orders.add(firstOrder);
        firstOrder.add(menu.get(5));firstOrder.add(menu.get(8));

        DefaultOrders secondOrder = new DefaultOrders(null, false);
        orders.add(secondOrder);
        secondOrder.add(menu.get(4));secondOrder.add(menu.get(6));

        DefaultOrders thirdOrder = new DefaultOrders("Jana Kazimierza 32", true);
        orders.add(thirdOrder);
        thirdOrder.add(menu.get(2));thirdOrder.add(menu.get(6));

        DefaultOrders fourthOrder = new DefaultOrders("Jana Kazimierza 48", true);
        orders.add(fourthOrder);
        fourthOrder.add(menu.get(7));fourthOrder.add(menu.get(3));

        DefaultOrders fifthOrder = new DefaultOrders(null, false);
        orders.add(fifthOrder);
        fifthOrder.add(menu.get(4));fifthOrder.add(menu.get(9));fifthOrder.add(menu.get(1));

        DefaultOrders sixthOrder = new DefaultOrders(null, false);
        orders.add(sixthOrder);
        sixthOrder.add(menu.get(4));sixthOrder.add(menu.get(4));

        DefaultOrders seventhOrder = new DefaultOrders(null, false);
        orders.add(seventhOrder);
        seventhOrder.add(menu.get(4));seventhOrder.add(menu.get(4));

        DefaultOrders eightOrder = new DefaultOrders(null, false);
        orders.add(eightOrder);
        eightOrder.add(menu.get(4));eightOrder.add(menu.get(1));eightOrder.add(menu.get(7));eightOrder.add(menu.get(8));eightOrder.add(menu.get(9));

        DefaultOrders ninethOrder = new DefaultOrders(null, false);
        orders.add(ninethOrder);
        ninethOrder.add(menu.get(4));ninethOrder.add(menu.get(4));

        DefaultOrders tenthOrder = new DefaultOrders(null, false);
        orders.add(tenthOrder);
        tenthOrder.add(menu.get(6));tenthOrder.add(menu.get(3));tenthOrder.add(menu.get(4));tenthOrder.add(menu.get(4));

        return orders;
    }

    static void startMakingOrders(ArrayList<Order> stationaryOrders, ArrayList<Order> onlineOrders){
        if(Kitchen.isOpened()) {
            System.out.println("STARTED MAKING ORDERS \n");
            System.out.println(" --- ONLINE ORDERS --- ");
            onlineOrders.forEach(Order::startMakingOrder);
            System.out.println("\n\n --- STATIONARY ORDERS --- \n\n ");
            stationaryOrders.forEach(Order::startMakingOrder);
            System.out.println("FINISHED MAKING AN ORDERS");
        } else {
            System.out.println("Can't start making orders, Kitchen is closed");
        }
    }

    static ArrayList<Order> getStationaryOrders(ArrayList<Order> orders) {
        return (ArrayList<Order>) orders.stream()
                .filter(Order::isOnline)
                .collect(Collectors.toList());
    }
    static ArrayList<Order> getOnlineOrders(ArrayList<Order> orders) {
        return (ArrayList<Order>) orders.stream()
                .filter(x -> !x.isOnline())
                .collect(Collectors.toList());
    }

}
