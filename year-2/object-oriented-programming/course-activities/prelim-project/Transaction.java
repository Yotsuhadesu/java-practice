public class Transaction {
    private String transactionID;
    private Customer customer;
    private Product product;
    private OrderDetails orderDetails;

    public Transaction(Customer customer, Product product, OrderDetails orderDetails) {
        this.transactionID = String.format("%05d", (getLastTransactionID() + 1));
        this.customer = customer;
        this.product = product;
        this.orderDetails = orderDetails;
    }

    public String getTransactionID() {
        return this.transactionID;
    }
    public String getCustomerFullName() {
        return this.customer.getLastName() + ", " + this.customer.getFirstName() + " " + this.customer.getMiddleName();
    }
    public String getOrderDateString() {
        return this.orderDetails.getOrderDate().toString();
    }
    public String getProductName() {
        return this.product.getProductName();
    }
    public String getTotalAmountString() {
        return String.valueOf(this.product.getTotalAmount());
    }
    public int getLastTransactionID() {
        return FileHandler.getLastTransactionID();
    }
}
