import java.util.ArrayList;

public class Product {
    private String productID;
    private String productName;
    private double price;
    private int quantity;
    private double totalAmount;
    private int stock;

     public Product(String productID, String productName, double price, int stock) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
    public Product(String productName, double price, int quantity, double totalAmount) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
    public Product() {

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void computeTotalAmount() {
        this.totalAmount = this.price * this.quantity;
    }

    public String getProductID() {
        return this.productID;
    }
    public String getProductName() {
        return this.productName;
    }
    public double getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public double getTotalAmount() {
        return this.totalAmount;
    }
    public int getStock() {
        return this.stock;
    }

    public static Product askProduct(ArrayList<Product> products) {
        System.out.println("--- PRODUCT INFORMATION FORM ---");
        if (products.isEmpty()) {
            System.out.println(">> There are no prducts. Please try loading the products first.");
        } else {
            System.out.printf("%-3s | %-15s | %-10s | %s \n", "ID", "PRODUCT", "PRICE", "STOCK");
            for (Product product : products) {
                System.out.printf("%-3s | %-15s | P%-9s | %s \n", product.getProductID(), product.getProductName(), String.valueOf(product.getPrice()), String.valueOf(product.getStock()));
            }
        }
        Product product = FileHandler.getProduct(Input.acceptString("Product ID:"));
        product.setQuantity(Input.acceptInt("Quantity:"));
        do {
            product.setQuantity(Input.acceptInt("Quantity:"));
        } while (product.getQuantity() > product.getStock());
        product.computeTotalAmount();
        return product;
    }

    public void showProductInfo() {
        System.out.println("--- PRODUCT DETAILS ---");
        System.out.println("Product Name: " + getProductName());
        System.out.println("Price: P" + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Total Amount: P" + getTotalAmount());
    }
}
