import java.util.LinkedList;
import java.util.Queue;

public class MenuSystem implements AquadelSystem {
    Queue<Transaction> transactions = new LinkedList<>();

    public void placeOrder() {
        Customer newCustomer = Customer.askCustomerInfo();
        Product newProduct = Product.askProduct();
        OrderDetails newOrderDetails = OrderDetails.askOrderDetails();
        newCustomer.showCustomerInfo();
        newProduct.showProductInfo();
        newOrderDetails.showOrderDetails();
        if(Input.acceptBoolean("Place Order (true/false)? ")) {
            transactions.add(new Transaction(newCustomer, newProduct, newOrderDetails));
            System.out.println(">> Transaction added to queue.");
        } else {
            System.out.println(">> Customer, Product, and Order was not added.");
        }
    }
}
