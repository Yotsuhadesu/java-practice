public class Product {
    private String productName;
    private double price;
    private int quantity;
    private double totalAmount;

    public Product(String productName, double price, int quantity, double totalAmount) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
    public Product() {

    }

    public void setPrice() {
        this.price = FileHandler.getProductPrice(this.productName);
    }
    public void setTotalAmount() {
        setPrice();
        this.totalAmount = this.price * this.quantity;
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

    public static Product askProduct() {
        System.out.println("--- PRODUCT INFORMATION FORM ---");
        FileHandler.showProducts();
        String productName = Input.acceptString("Product Name:");
        double price = FileHandler.getProductPrice(productName);
        int quantity = Input.acceptInt("Quantity:");
        double totalAmount =  price * quantity;
        return new Product(productName, price, quantity, totalAmount);
    }

    public void showProductInfo() {
        System.out.println("--- PRODUCT DETAILS ---");
        System.out.println("Product Name: " + getProductName());
        System.out.println("Price: P" + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Total Amount: P" + getTotalAmount());
    }
}
