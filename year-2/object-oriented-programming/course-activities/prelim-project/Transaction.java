import java.time.LocalDate;

public class Transaction {
    private String transactionID;
    private LocalDate orderDate;
    private String customerID;
    private Customer customer;
    private String customerFullName;
    private String productID;
    private Product product;
    private String productName;
    private int quantity;
    private String deliveryMethod;
    private double totalAmount;
    private String status;

    public Transaction(String transactionID, LocalDate orderDate, String customerID, Customer customer, String productID, Product product, int quantity, String deliveryMethod, double totalAmount, String status) {
        this.transactionID = transactionID;
        this.customerID = customerID;
        this.productID = productID;
        this.customer = customer;
        this.customerFullName = this.customer.getFullName();
        this.product = product;
        this.productName = this.product.getProductName();
        this.quantity = quantity;
        this.deliveryMethod = deliveryMethod;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }
    public Transaction(LocalDate orderDate, String customerID, String productID, int quantity, String deliveryMethod, double totalAmount, String status) {
        this.transactionID = String.format("%05d", (getLastTransactionID() + 1));
        this.customerID = customerID;
        this.productID = productID;
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
    public String getCustomerID() {
        return this.customerID;
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
        return this.deliveryMethod;
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
