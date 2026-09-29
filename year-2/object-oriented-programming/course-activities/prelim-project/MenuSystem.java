import java.util.ArrayList;

public class MenuSystem {
    ArrayList<Customer> customers = new ArrayList<>();
    OrderDetails orderDetails = new OrderDetails();

    public void askCustomerInfo() {
        customers.add(Customer.askCustomerInfo());
    }

    public void askOrderDetails() {
        orderDetails = OrderDetails.askOrderDetails();
    }
}
