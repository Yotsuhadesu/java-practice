public class Transaction {
    private String transactionID;
    private Customer customer;
    private Product product;
    private OrderDetails orderDetails;

    public Transaction() {

    }

    public void setLastTransactionID() {
        this.transactionID = FileHandler.getLastTransactionID();
    }
}
