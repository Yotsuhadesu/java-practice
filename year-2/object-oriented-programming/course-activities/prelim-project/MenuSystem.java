import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MenuSystem implements AquadelSystem {
    Queue<Transaction> orders = new LinkedList<>();
    ArrayList<Product> products = new ArrayList<>();

    public void loadProducts() {
        products = FileHandler.loadProducts();
    }
    public void placeOrder() {
        Customer newCustomer = Customer.askCustomerInfo();
        Product newProduct = Product.askProduct(this.products);
        Order newOrder = Order.askOrderInformation();
        newCustomer.showCustomerInfo();
        newProduct.showProductInfo();
        newOrder.showOrderInformation();
        if(Input.acceptBoolean("Place Order (true/false)? ")) {
            Transaction newTransaction = new Transaction(
                newOrder.getOrderDate(), 
                newCustomer.getFullName(), 
                newProduct.getProductName(), 
                newProduct.getQuantity(),
                newOrder.getDeliveryMethod(),
                newProduct.getTotalAmount(), 
                "Pending"
            );
            orders.add(newTransaction);
            System.out.println(">> Order added to queue.");
            FileHandler.saveTransaction(newTransaction);
        } else {
            System.out.println(">> Order was cancelled.");
        }
    }

    public void viewOrders() {
        System.out.println("--- ORDERS IN QUEUE ---");
        System.out.printf(" %-5s | %-10s | %-40s | %-15s | %-5s | %-5s | %-5s | %s \n", 
            "ID", 
            "DATE", 
            "NAME", 
            "PRODUCT", 
            "QUANTITY",
            "METHOD",
            "AMOUNT", 
            "STATUS"
        );
        for(Transaction transaction : this.orders) {
            System.out.printf(
                " %-5s | %-10s | %-40s | %-15s | %-5s | %-5s | %-5s | %s \n",
                transaction.getTransactionID(),
                transaction.getOrderDate().toString(),
                transaction.getCustomerFullName(),
                transaction.getProductName(),
                String.valueOf(transaction.getQuantity()),
                transaction.getDeliveryMethod(),
                String.valueOf(transaction.getTotalAmount()),
                transaction.getStatus()
            );
        }
        System.out.println(">> Shown all orders in queue.");
    }

    public void updateOrderStatus() {
        System.out.println("--- UPDATE ORDER STATUS ---");
        String transactionID = Input.acceptString("ID: ");
        Transaction transaction = new Transaction();
        boolean exists = false;
        for (Transaction currentTransaction : this.orders) {
            if (currentTransaction.getTransactionID().equals(transactionID)) {
                transaction = currentTransaction;
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.printf(
                " %-5s | %-10s | %-40s | %-15s | %-5s | %-5s | %-5s | %s \n",
                transaction.getTransactionID(),
                transaction.getOrderDate().toString(),
                transaction.getCustomerFullName(),
                transaction.getProductName(),
                String.valueOf(transaction.getQuantity()),
                transaction.getDeliveryMethod(),
                String.valueOf(transaction.getTotalAmount()),
                transaction.getStatus()
            );
            int choice = Input.acceptInt("""
                Pick Status:
                1. Cancelled
                2. Delivering
                3. Settled
                Choice:\s""");
            do {
                switch (choice) {
                case 1:
                    transaction.setStatus("Cancellled");
                    break;
                case 2:
                    transaction.setStatus("Delivering");
                    break;
                case 3:
                    transaction.setStatus("Settled");
                    break;
                default:
                    System.out.println(">> Invalid choice.");
                    break;
            }
            } while (choice != 1 && choice != 2 && choice != 3);
            System.out.println(">> Status updated successfully.");
        } else {
            System.out.println(">> Order ID doesn't exist.");
        }
    }
}
