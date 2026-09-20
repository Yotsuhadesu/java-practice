import java.time.LocalDate;

public class OrderDetails {
    private Order order;
    private Product product;

    public OrderDetails(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public OrderDetails() {
        
    }

    public static OrderDetails askOrderDetails() {
        System.out.println("--- ORDER DETAILS FORM ---");
        FileHandler.showProducts();
        String productName = Input.acceptString("Product Name:");
        int productQuantity = Input.acceptInt("Quantity:");
        String deliveryMethod = null;
        do {
            switch (Input.acceptInt("""
                Delivery Methods
                1. Pickup
                2. Delivery
                Choice:\s""")) {
                case 1:
                    deliveryMethod = "Pickup";
                    break;
                case 2:
                    deliveryMethod = "Deliver";
                    break;
                default:
                    System.out.println(">> Invalid Delivery Method.");
                    break;
            }
        } while (deliveryMethod == null || (!deliveryMethod.equals("Pickup")  && !deliveryMethod.equals("Deliver")));
        return new OrderDetails(new Order(deliveryMethod, LocalDate.now()), new Product(productName, productQuantity));
    }
}
