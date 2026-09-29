import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileHandler {
    // PRODUCT FILE HANDLER METHODS
    final static File productsFile = new File("Products.txt");

    // extract products from the file to an arraylist
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

    // update product stocks 
    public static void updateStock(Product product, String opration) {
        String productID = product.getProductID();
        int updatedStock = product.getStock();
        System.out.println(">> The product ID is " + productID + " and the stock is " + updatedStock);
        if (opration.equals("ADD")) {
            updatedStock += product.getQuantity();
        } else if (opration.equals("SUBTRACT")) {
            updatedStock -= product.getQuantity();
        }
        System.out.println("The updated stock is " + updatedStock);

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");
                if (attributes[0].equals(productID)) {
                    lines.add(attributes[0] + "|" + attributes[1] + "|" + attributes[2] + "|" + String.valueOf(updatedStock));
                }
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the product file.");
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(productsFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while overwriting the product file.");
            e.printStackTrace();
        }
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
                transaction.getProductID() + "|" + 
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

    // extract orders from file to queue
    public static Queue<Transaction> loadOrders() {
        Queue<Transaction> transactions = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");
                if (!attributes[7].equals("Settled") && !attributes[7].equals("Cancelled")) {
                    transactions.add(new Transaction(
                        attributes[0], 
                        LocalDate.parse(attributes[1]), 
                        attributes[2], 
                        attributes[3], 
                        Integer.parseInt(attributes[4]), 
                        attributes[5], 
                        Double.parseDouble(attributes[6]), 
                        attributes[7]));
                } 
            }
            System.out.println(">> Unsettled orders fetched succesfully.");
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the transaction file.");
            e.printStackTrace();
        }
        return transactions;
    }

    // CUSTOMER FILE HANDLER


    // CASHIER FILE HADNLER
}