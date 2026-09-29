import java.util.ArrayList;

public class MenuSystem implements AquadelSystem {
    ArrayList<Customer> customers = new ArrayList<>();
    Product product = new Product();
    OrderDetails orderDetails = new OrderDetails();

    public void placeOrder() {
        Customer newCustomer = Customer.askCustomerInfo();
        Product newProduct = Product.askProduct();
        OrderDetails newOrderDetails = OrderDetails.askOrderDetails();
        newCustomer.showCustomerInfo();
        newProduct.showProductInfo();
        newOrderDetails.showOrderDetails();
        if(Input.acceptBoolean("Place Order (true/false)? ")) {
            this.customers.add(newCustomer);
            this.product = newProduct;
            this.orderDetails = newOrderDetails;
            System.out.println(">> Customer, Product, and Order added successfully.");
        } else {
            System.out.println(">> Customer, Product, and Order was not added.");
        }
    }
}
