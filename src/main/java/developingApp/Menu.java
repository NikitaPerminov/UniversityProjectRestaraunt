package developingApp;

import java.util.ArrayList;

public class Menu extends ArrayList<Dishes> {

	private static final long serialVersionUID = 1L;
	public static Menu initializeMenu() {

        Menu menu = new Menu();

        Dishes Soba  = new Dishes("Soba", 15, true, false, true);
        Dishes Tempura = new Dishes("Tempura", 20, true, false, false);
        Dishes fruitcake = new Dishes("Fruit cake", 29, false, false, true);
        Dishes friedDuck = new Dishes("Fried Duck", 35, true, false, false);
        Dishes koreanTofu = new Dishes("Korean Tofu", 29, true, true, false);
        Dishes braisedBeef = new Dishes("Braised Beef", 33, true, false, false);

        Dishes smallWater = new Dishes("Small Water", 4, true, true, false);
        Dishes bigWater = new Dishes("Big Water", 6, true, true, false);
        Dishes wine = new Dishes("Wine", 12, true, true, false);
        Dishes beer = new Dishes("Beer", 9, true, true, false);
        Dishes cola = new Dishes("Cola", 5, true, true, false);

        menu.add(Soba);
        menu.add(Tempura);
        menu.add(fruitcake);
        menu.add(friedDuck);
        menu.add(koreanTofu);
        menu.add(braisedBeef);

        menu.add(smallWater);
        menu.add(bigWater);
        menu.add(wine);
        menu.add(beer);
        menu.add(cola);
        
        return menu;

    }


    public static void showMenu(Menu menu){
        menu.forEach(x -> System.out.println(x.toStringInMenu()));
    }
    public static void onlyVegan(Menu menu){
        menu.stream().filter(x -> x.isVegan()).forEach(x -> System.out.println(x.toStringInMenu()));
    }
    public static void onlySpicy(Menu menu){
        menu.stream().filter(x -> x.isSpicy()).forEach(x -> System.out.println(x.toStringInMenu()));
    }


	public static Object stop() {
		return null;
	}


	public static Object remove() {
		return null;
	}

}
