package developingApp;

import java.util.concurrent.atomic.AtomicInteger;

public class Dishes {
    private final String name;
    private final int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private double price;
    private boolean isAvailable;
    private boolean isVegan;
    private boolean isSpicy;
    private boolean isFinished;

    public Dishes(String name, double price, boolean isPresent, boolean isVegan, boolean isSpicy) {
        this.name = name;
        this.price = price;
        this.isAvailable = isPresent;
        this.isVegan = isVegan;
        this.isSpicy = isSpicy;
        id = count.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", isVegan=" + isVegan +
                ", isSpicy=" + isSpicy +
                ", isFinished=" + isFinished +
                '}';
    }
    public String toStringInMenu() {
        return  (this.isAvailable() ? "Yes" : "No") + this.getName() + " | Price: " + this.getPrice() + " | Vegan: " + (this.isVegan() ? "Yes" : "No" ) + " | Spicy: " + (this.isSpicy() ? "Yes" : "No" );

    }
    public String onlyVegan(){
        return this.isVegan ? toStringInMenu() : "";
    }
    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    
    private boolean checkIsAvailable() throws UnavaliableError {
        boolean check = false;
            if(isAvailable){
                check = true;
            }
            else{
                throw new UnavaliableError("This position currently is not Available :( ");
            }
            return check;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public int getId() {
        return id;
    }

    public void startMakingDish()  {
            try {
                Thread.sleep((long) (00));
                isFinished = true;
                System.out.println("* Dish is finished: " + getName());
            } catch (InterruptedException e) {
            	
            }
    }
    public void skip(){
        isFinished = true;
    }
    
}
