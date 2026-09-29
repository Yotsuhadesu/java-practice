import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    // PRODUCT FILE HANDLER
    final static File productsFile = new File("Products.txt");
    public static void showProducts() {
        // check if the file exists or is empty
        if (!productsFile.exists() || productsFile.length() == 0) {
            System.out.println(">> There are no products.");
            return;
        }
        // show the products
        System.out.printf("%-15s | %-10s | %-10s \n", "PRODUCT", "PRICE", "STOCK");
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productAttributes = line.split("\\|");
                System.out.printf("%-15s | P%-9s | %-10s \n", productAttributes[0], productAttributes[1], productAttributes[2]);
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the file.");
            e.printStackTrace();
        } 
    }

    public static double getProductPrice(String productName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productAttributes = line.split("\\|");
                if (productAttributes[0].equals(productName)) {
                    double price = Double.parseDouble(productAttributes[1]);
                    return price;
                }
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the file.");
            e.printStackTrace();
        } 
        System.out.println(">> The system could not find the product name.");
        return 0;
    }

    // TRANSACTION FILE HANDLER
    final static File transactionFile = new File("Transaction.txt");
    public static int getLastTransactionID() {
        // check if the file exists or is empty
        if (!transactionFile.exists() || transactionFile.length() == 0) {
            System.out.println(">> There are no transactions.");
            return 0;
        }
        String lastLine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lastLine = currentLine;
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the file.");
            e.printStackTrace();
        } 
        return Integer.parseInt(lastLine.split("\\|")[0]);
    }

    public static void saveTransaction(Transaction transaction) {
        if (!transactionFile.exists()) {
            System.out.println(">> Transaction file doesn't exist.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionFile, true))) {
            // Transaction ID|Order Date|Customer Name|Product Name|Total Amount|Status
            writer.write(
                transaction.getTransactionID() + "|" + 
                transaction.getOrderDate().toString() + "|" + 
                transaction.getCustomerFullName() + "|" + 
                transaction.getProductName() + "|" + 
                String.valueOf(transaction.getQuantity()) + "|" +
                transaction.getDeliveryMethod() + "|" +
                String.valueOf(transaction.getTotalAmount()) + "|" +
                transaction.getStatus()
            );
            writer.newLine();
            System.out.println(">> Transaction saved to file successfully.");
        } catch (Exception e) {
            System.out.println(">> An error occurred while saving the transaction.");
            e.printStackTrace();
        }
    }

    public static void updateTransaction(Transaction updatedTransaction) {
        // get the updated Transaction String
        String updatedTransactionString = updatedTransaction.getTransactionID() + "|" + 
                updatedTransaction.getOrderDate().toString() + "|" + 
                updatedTransaction.getCustomerFullName() + "|" + 
                updatedTransaction.getProductName() + "|" + 
                String.valueOf(updatedTransaction.getQuantity()) + "|" +
                updatedTransaction.getDeliveryMethod() + "|" +
                String.valueOf(updatedTransaction.getTotalAmount()) + "|" +
                updatedTransaction.getStatus()
            ;

        // replace the outdated transaction and store in a list
        List<String> transactionStrings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.split("\\|")[0].equals(updatedTransaction.getTransactionID())) {
                    transactionStrings.add(updatedTransactionString);
                }  else {
                    transactionStrings.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the transaction file.");
            e.printStackTrace();
        }

        // write the updated transactions to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionFile))) {
            for (String line : transactionStrings) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while writing the updated transaction file.");
            e.printStackTrace();
        }
    }
}
