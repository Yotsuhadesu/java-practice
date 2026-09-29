import java.time.LocalDate;

public class Order {
    private boolean toDeliver;
    private String deliveryMethod;
    private LocalDate orderDate;

    public Order(boolean toDeliver, String deliveryMethod, LocalDate orderDate) {
        this.toDeliver = toDeliver;
        this.deliveryMethod = deliveryMethod;
        this.orderDate = orderDate;
    }
    public Order() {
        
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public void setToDeliver(boolean toDeliver) {
        this.toDeliver = toDeliver;
    }

    public boolean getToDeliver() {
        return this.toDeliver;
    }
    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setDeliveryMethod(boolean toDeliver) {
        if (toDeliver) {
            this.deliveryMethod = "Delivery";
        } else {
            this.deliveryMethod = "Pickup";
        }
    }
    public String getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public static Order askOrderInformation() {
        Order order = new Order();
        System.out.println("--- ORDER DETAILS FORM ---");
        boolean toDeliver = true;
        boolean isValid = false;
        do {
            switch (Input.acceptInt("""
                Delivery Methods
                1. Pickup
                2. Delivery
                Choice:\s""")) {
                case 1:
                    toDeliver = false;
                    isValid = true;
                    break;
                case 2:
                    toDeliver = true;
                    isValid = true;
                    break;
                default:
                    System.out.println(">> Invalid Delivery Method.");
                    isValid = false;
                    break;
            }
        } while (!isValid);
        order.setToDeliver(toDeliver);
        order.setDeliveryMethod(toDeliver);
        order.setOrderDate(LocalDate.now());
        return order;
    }

    public void showOrderInformation() {
        System.out.println("--- ORDER INFORMATION ---");
        System.out.println("Delivery Method: " + getDeliveryMethod());
        System.out.println("Date: " + getOrderDate());
    }
}
