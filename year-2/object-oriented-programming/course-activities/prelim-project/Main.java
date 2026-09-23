public class Main {
    public static void main(String[] args) {
        MenuSystem menuSystem = new MenuSystem();
        int choice;
        do {
            Input.showMenu();
            choice = Input.acceptInt("Choice:");
            switch (choice) {
                case 1:
                    menuSystem.placeOrder();
                    break;
                case 2:
                    menuSystem.viewOrders();
                    break;
                case 3:
                    menuSystem.loadProducts();
                    break;
                case 0:
                    System.out.println(">> Exiting the program...");
                    break;
                default:
                    System.out.println(">> Invalid choice.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }
}
