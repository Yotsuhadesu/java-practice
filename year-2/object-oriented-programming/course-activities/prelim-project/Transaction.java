import java.time.LocalDate;

public class Transaction {
    private String transactionID;
    private LocalDate orderDate;
    private String customerFullName;
    String productID;
    Product product;
    private String productName;
    private int quantity;
    private String deliveryMethod;
    private double totalAmount;
    private String status;

    public Transaction(String transactionID, LocalDate orderDate, String customerFullName, String productID, int quantity, String deliveryMethod, double totalAmount, String status) {
        this.transactionID = transactionID;
        this.customerFullName = customerFullName;
        this.productID = productID;
        this.product = FileHandler.getProduct(productID);
        this.productName = this.product.getProductName();
        this.quantity = quantity;
        this.deliveryMethod = deliveryMethod;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }
    public Transaction(LocalDate orderDate, String customerFullName, String productName, int quantity, String deliveryMethod, double totalAmount, String status) {
        this.transactionID = String.format("%05d", (getLastTransactionID() + 1));
        this.customerFullName = customerFullName;
        this.productName = productName;
        this.quantity = quantity;
        this.deliveryMethod = deliveryMethod;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }
    public Transaction() {

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionID() {
        return this.transactionID;
    }
    public String getCustomerFullName() {
        return this.customerFullName;
    }
    public LocalDate getOrderDate() {
        return this.orderDate;
    }
    public String getProductID() {
        return this.productID;
    }
    public String getProductName() {
        return this.productName;
    }
    public Product getProduct() {
        return this.product;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public String getDeliveryMethod() {
        return  this.deliveryMethod;
    }
    public double getTotalAmount() {
        return this.totalAmount;
    }
    public String getStatus() {
        return this.status;
    }
    public int getLastTransactionID() {
        return FileHandler.getLastTransactionID();
    }
}
