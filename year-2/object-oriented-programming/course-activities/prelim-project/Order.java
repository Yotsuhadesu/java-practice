import java.time.LocalDate;

public class Order {
    private String deliveryMethod;
    private LocalDate orderDate;

    public Order(String deliveryMethod, LocalDate orderDate) {
        this.deliveryMethod = deliveryMethod;
        this.orderDate = orderDate;
    }
}
