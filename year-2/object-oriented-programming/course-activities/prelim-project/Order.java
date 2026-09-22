import java.time.LocalDate;

public class Order {
    private String deliveryMethod;
    private LocalDate orderDate;

    public Order(String deliveryMethod, LocalDate orderDate) {
        this.deliveryMethod = deliveryMethod;
        this.orderDate = orderDate;
    }
    public Order() {
        
    }

    public String getDeliveryMethod() {
        return this.deliveryMethod;
    }
    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public static Order askOrderInformation() {
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
        return new Order(deliveryMethod, LocalDate.now());
    }

    public void showOrderInformation() {
        System.out.println("--- ORDER INFORMATION ---");
        System.out.println("Delivery Method: " + getDeliveryMethod());
        System.out.println("Date: " + getOrderDate());
    }
}
