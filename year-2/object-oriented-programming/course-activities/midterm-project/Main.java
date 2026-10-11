public class Main {
    public static void main(String[] args) {
        TransactionRecord transactionRecord = new TransactionRecord();
        System.out.println("=== AQUADEL TRANSACTION MANAGEMENT SYSTEM ===");
        System.out.println("--------- TRANSACTION RECORDING APP ---------");
        do {
            transactionRecord.setTransactions();
            System.out.println();
            InputHandler.showMenu();
            switch (InputHandler.acceptInt("Choice")) {
                case 1:
                    transactionRecord.addRecord();
                    break;
                case 2:
                    transactionRecord.updateRecord();
                    break;
                case 3: 
                    transactionRecord.deleteRecord();
                    break;
                case 4:
                    transactionRecord.viewRecord();
                    break;
                case 5:
                    transactionRecord.viewList();
                    break;
                case 6:
                    System.out.println(">> Exiting the aquadel transaction recording app.");
                    return;
                default:
                    System.out.println(">> Please enter a valid choice.");
                    break;
            }
            FileHandler.saveTransactions(transactionRecord.getTransactions());
        } while (true);
    }
}