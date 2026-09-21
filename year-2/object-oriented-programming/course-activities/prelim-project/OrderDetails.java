import java.time.LocalDate;

public class OrderDetails {
    private String deliveryMethod;
    private LocalDate orderDate;

    public OrderDetails(String deliveryMethod, LocalDate orderDate) {
        this.deliveryMethod = deliveryMethod;
        this.orderDate = orderDate;
    }
    public OrderDetails() {
        
    }

    public String getDeliveryMethod() {
        return this.deliveryMethod;
    }
    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public static OrderDetails askOrderDetails() {
        System.out.println("--- ORDER DETAILS FORM ---");
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
        return new OrderDetails(deliveryMethod, LocalDate.now());
    }

    public void showOrderDetails() {
        System.out.println("--- ORDER DETAILS ---");
        System.out.println("Delivery Method: " + getDeliveryMethod());
        System.out.println("Date: " + getOrderDate());
    }
}
