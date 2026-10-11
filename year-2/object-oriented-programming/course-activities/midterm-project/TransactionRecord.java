import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionRecord implements RecordManager {
    private ArrayList<Transaction> transactions;

    public void setTransactions() {
        this.transactions = FileHandler.loadTransactions();
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    @Override 
    public void addRecord() { 
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
        boolean isValid = false;
        while (!isValid) {
            try {
                transaction.setItemQuantity(InputHandler.acceptInt("Quantity"));
                isValid = true;
            } catch (InvalidTransactionException e) {
                System.out.println(e.getMessage());
            }
        }
        isValid = false;
        while (!isValid) {
            try {
                transaction.setItemPrice(InputHandler.acceptBigDecimal("Price"));
                isValid = true;
            } catch (InvalidTransactionException e) {
                System.out.println(e.getMessage());
            }
        }
        isValid = false;
        while (!isValid) {
            try {
                transaction.setDelFee(InputHandler.acceptBigDecimal("Delivery Fee"));
                isValid = true;
            } catch (InvalidTransactionException e) {
                System.out.println(e.getMessage());
            }
        }
        transaction.compTotAmount();
        transaction.setPayMethod(InputHandler.acceptString("Payment Method"));
        transaction.setTranStatus(InputHandler.acceptString("Transaction Status"));
        transactions.add(transaction);
    }
    @Override 
    public void updateRecord() {
        int tranIndex = getRecordIndex();
        if (tranIndex != -1) {
            Transaction transaction = transactions.get(tranIndex);
            System.out.println(">> Transaction record found.");
            InputHandler.showHeadTable();
            showForTran(transaction);
            System.out.println("""
                    Edit:
                    [1] Last Name
                    [2] First Name
                    [3] Contact Number
                    [4] Status""");
            switch (InputHandler.acceptInt("Choice")) {
                case 1:
                    String updLastName = InputHandler.acceptString("Last Name");
                    if (InputHandler.acceptBoolean("Update " + transaction.getCusLastName() + " to " + updLastName + "? (true/false)")) {
                        transaction.setCusLastName(updLastName);
                    } else {
                        System.out.println(">> Last Name update cancelled.");
                    }
                    break;
                case 2:
                    String updFirstName = InputHandler.acceptString("First Name");
                    if (InputHandler.acceptBoolean("Update " + transaction.getCusFirstName() + " to " + updFirstName + "? (true/false)")) {
                        transaction.setCusFirstName(updFirstName);
                    } else {
                        System.out.println(">> First Name update cancelled.");
                    }
                    break;
                case 3:
                    String updConNum = InputHandler.acceptString("Contact Number");
                    if (InputHandler.acceptBoolean("Update " + transaction.getCusConNum() + " to " + updConNum + "? (true/false)")) {
                        transaction.setCusConNum(updConNum);
                    } else {
                        System.out.println(">> Contact number update cancelled.");
                    }
                    break;
                case 4:
                    String updStatus = InputHandler.acceptString("Status");
                    if (InputHandler.acceptBoolean("Update " + transaction.getTranStatus() + " to " + updStatus + "? (true/false)")) {
                        transaction.setTranStatus(updStatus);
                    } else {
                        System.out.println(">> Transaction status update cancelled.");
                    }
                    break;
                default:
                    System.out.println(">> Invalid choice.");
                    break;
            }
        } else {
            System.out.println(">> Transaction record not found.");
        }
    }
    @Override 
    public void deleteRecord() {
        int tranIndex = getRecordIndex();
        if (tranIndex != -1) {
            Transaction transaction = transactions.get(tranIndex);
            System.out.println(">> Transaction record found.");
            InputHandler.showHeadTable();
            showForTran(transaction);
            if (InputHandler.acceptBoolean("Remove transaction? (true/false)")) {
                transactions.remove(transaction);
            }
        } else {
            System.out.println(">> Transaction record not found.");
        }
    }
    @Override 
    public void viewRecord() {
        int tranIndex = getRecordIndex();
        if (tranIndex != -1) {
            Transaction transaction = transactions.get(tranIndex);
            System.out.println(">> Transaction record found.");
            InputHandler.showHeadTable();
            showForTran(transaction);
        } else {
            return;
        }
    }
    @Override 
    public void viewList() {
        InputHandler.showHeadTable();
        for (Transaction transaction : transactions) {
            showForTran(transaction);
        }
    }
    @Override 
    public int getRecordIndex() {
        int id = InputHandler.acceptId();
        int i = 0;
        for (Transaction transaction : transactions) {
            if (id == transaction.getRecordID()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void showForTran(Transaction transaction) {
         System.out.printf(
            "%-3s %-10s %-15s %-15s %-11s %-25s %-10s %-10s P%-5s P%-5s P%-10s %-10s %-10s\n",
            String.valueOf(transaction.getRecordID()), String.valueOf(transaction.getTranDate()), 
            String.valueOf(transaction.getCusLastName()), String.valueOf(transaction.getCusFirstName()),
            String.valueOf(transaction.getCusConNum()), String.valueOf(transaction.getDelAddress()),
            String.valueOf(transaction.getItem()),String.valueOf(transaction.getItemQuantity()), 
            String.valueOf(transaction.getItemPrice()), String.valueOf(transaction.getDelFee()), 
            String.valueOf(transaction.getTotAmount()), String.valueOf(transaction.getPayMethod()), 
            String.valueOf(transaction.getTranStatus())
        );
    }
}