import java.util.ArrayList;

public class MenuSystem {
    ArrayList<Customer> customers = new ArrayList<>();

    public void askCustomerInfo() {
        customers.add(Customer.askCustomerInfo());
    }
}
