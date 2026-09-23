public interface AquadelSystem {
    default String getBusinessName() {
        return "Aquadel Water Refilling Station";
    }
    void loadProducts();
    void placeOrder();
    void viewOrders();
    void updateOrderStatus();
}
