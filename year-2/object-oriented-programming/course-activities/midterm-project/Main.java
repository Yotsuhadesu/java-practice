import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== AQUADEL TRANSACTION MANAGEMENT SYSTEM ===");
        System.out.println("--------- TRANSACTION RECORDING APP ---------");
        do {
            InputHandler.showMenu();
            switch (InputHandler.acceptInt("Choice")) {
                case 1:
                    break;
                case 6:
                    return;
                default:
                    System.out.println(">> Please enter a valid choice.");
                    break;
            }
        } while (true);
    }

    public Transaction addTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTranID(FileHandler.getLastTranId() + 1);
        transaction.setTranDate(LocalDate.now());
        System.out.println("--- CUSTOMER INFORMATION ---");
        transaction.setCusLastName(InputHandler.acceptString("Last Name"));
        transaction.setCusFirstName(InputHandler.acceptString("First Name"));
        transaction.setCusConNum(InputHandler.acceptString("Contact Number"));
        transaction.setDelAddress(InputHandler.acceptString("Delivery Address"));
        System.out.println("--- ITEM INFORMATION ---");
        transaction.setItem(InputHandler.acceptString("Name"));
        transaction.setItemQuantity(InputHandler.acceptInt("Quantity"));
        transaction.setItemPrice(InputHandler.acceptBigDecimal("Price"));
        transaction.setDelFee(InputHandler.acceptBigDecimal("Delivery Fee"));
        transaction.compTotAmount();
        return transaction;
    }
}
