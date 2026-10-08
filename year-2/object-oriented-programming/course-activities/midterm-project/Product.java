import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private String productID;
    private String productName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalAmount;
    private int stock;
    private boolean toDeliver;

     public Product(String productID, String productName, BigDecimal price, int stock) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
    public Product(String productName, BigDecimal price, int quantity, BigDecimal totalAmount) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
    public Product() {

    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setToDeliver(boolean toDeliver) {
        this.toDeliver = toDeliver;
    }
    public void computeTotalAmount() {
        if (this.toDeliver) {
            this.totalAmount = (this.price.multiply(BigDecimal.valueOf(quantity))).add(BigDecimal.valueOf(5));
        } else {
            this.totalAmount = this.price.multiply(BigDecimal.valueOf(quantity));
        }
    }

    public static Product getProduct(ArrayList<Product> products, String productID) {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        System.out.println(">> Product cannot be found.");
        return new Product();
    }
    public String getProductID() {
        return this.productID;
    }
    public String getProductName() {
        return this.productName;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }
    public int getStock() {
        return this.stock;
    }

    public static Product askProduct(ArrayList<Product> products) {
        System.out.println("--- PRODUCT INFORMATION FORM ---");
        if (products.isEmpty()) {
            System.out.println(">> There are no prducts.");
            return new Product();
        } else {
            System.out.printf("%-3s | %-15s | %-10s | %s \n", "ID", "PRODUCT", "PRICE", "STOCK");
            for (Product product : products) {
                System.out.printf("%-3s | %-15s | P%-9s | %s \n", product.getProductID(), product.getProductName(), String.valueOf(product.getPrice()), String.valueOf(product.getStock()));
            }
        }

        String productID = Input.acceptString("Product ID:");
        Product product = FileHandler.getProduct(productID);
        while (product.getProductID() == null || product.getStock() <= 0) {
            if (product.getProductID() == null) {
                System.out.println(">> Product ID does not exist.");
            } else {
                System.out.println(">> Product out of stock");
            }

            if (Input.acceptBoolean(">> Cancel? (true/false)")) {
                return new Product();
            }

            productID = Input.acceptString("Product ID:");
            product = FileHandler.getProduct(productID);
        }
        product.setProductID(productID);

        product.setQuantity(Input.acceptInt("Quantity:"));
        while (product.getQuantity() > product.getStock() || product.getQuantity() <= 0) {
            if (product.getQuantity() > product.getStock()) {
                System.out.println(">> Quantity is greater than the stock, please try again.");
            } else if (product.getQuantity() <= 0) {
                System.out.println(">> Quantity must not be zero or negative, please try again.");
            }

            if (Input.acceptBoolean(">> Cancel? (true/false)")) {
                return new Product();
            }

            product.setQuantity(Input.acceptInt("Quantity:"));
        }
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
