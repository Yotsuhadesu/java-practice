public class Main {
    public static void main(String[] args) {
        MenuSystem menuSystem = new MenuSystem();
        int choice;
        do {
            Input.showMenu();
            choice = Input.acceptInt("Choice:");
            switch (choice) {
                case 1:
                    menuSystem.askCustomerInfo();
                    menuSystem.askOrderDetails();
                    break;
                case 0:
                    System.out.println(">> Exiting the program...");
                    break;
                default:
                    System.out.println(">> Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }
}
