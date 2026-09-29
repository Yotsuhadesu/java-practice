import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MenuSystem implements AquadelSystem {
    Queue<Transaction> orders = new LinkedList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    public void loadOrders() {
        this.orders.clear();
        this.orders = FileHandler.loadOrders();
    }
    public void loadProducts() {
        this.products = FileHandler.loadProducts();
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
            System.out.println(">> Transaction saved to file.");
            FileHandler.updateStock(newProduct, "SUBTRACT");
            System.out.println(">> Stock updated successfully.");
        } else {
            System.out.println(">> Order was cancelled.");
        }
    }

    public void viewOrders() {
        System.out.println("--- ORDERS IN QUEUE ---");

        if (this.orders.isEmpty()) {
            System.out.println(">> There are no orders in queue.");
            return; 
        }

        System.out.printf(" %-5s | %-10s | %-35s | %-20s | %-10s | %-10s | %-10s | %s \n", 
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
                " %-5s | %-10s | %-35s | %-20s | %-10s | %-10s | %-10s | %s \n",
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
        String transactionID = Input.acceptString("ID:");
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
            switch (choice) {
                case 1:
                    transaction.setStatus("Cancelled");
                    FileHandler.updateStock(transaction.getProduct(), "ADD");
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
            FileHandler.updateTransaction(transaction);
            System.out.println(">> Status updated successfully.");
        } else {
            System.out.println(">> Order ID doesn't exist.");
        }
    }
}