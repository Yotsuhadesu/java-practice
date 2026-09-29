import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    // PRODUCT FILE HANDLER METHODS
    final static File productsFile = new File("Products.txt");
    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");
                products.add(new Product(attributes[0], attributes[1], Double.parseDouble(attributes[2]), Integer.parseInt(attributes[3])));
            }
            System.out.println(">> Products extracted successfully.");
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the product file.");
            e.printStackTrace();
        }
        return products;
    }

    // return the product object by ID
    public static Product getProduct(String productID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");
                if (attributes[0].equals(productID)) {
                    return new Product(attributes[0], attributes[1], Double.parseDouble(attributes[2]), Integer.parseInt(attributes[3]));
                }
            }
            System.out.println(">> Product ID does not exist.");
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the product file.");
            e.printStackTrace();
        }
        return new Product();
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

    // CUSTOMER FILE HANDLER

    // CASHIER FILE HADNLER
}