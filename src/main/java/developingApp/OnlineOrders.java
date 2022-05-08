package developingApp;

import java.time.LocalDateTime;

public class OnlineOrders extends Order{

	private static final long serialVersionUID = 1L;

	private LocalDateTime dateOfOreder;

    private String adress;

    public OnlineOrders(String adress, boolean isOnline) {
        super(isOnline);
        this.adress = adress;
    }


    public LocalDateTime getDateOfOreder() {
        return dateOfOreder;
    }

    public String getAdress() {
        return adress;
    }
}
