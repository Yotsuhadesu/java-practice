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
            System.out.println(">> Products fetched successfully.");
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
    public static void updateStock(Product product, int quantity, String opration) {
        String productID = product.getProductID();
        int updatedStock = product.getStock();
        if (opration.equals("ADD")) {
            updatedStock += quantity;
        } else if (opration.equals("SUBTRACT")) {
            updatedStock -= quantity;
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");
                if (attributes[0].equals(productID)) {
                    lines.add(attributes[0] + "|" + attributes[1] + "|" + attributes[2] + "|" + String.valueOf(updatedStock));
                    continue;
                }
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the product file.");
            e.printStackTrace();
            return; 
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
            // Transaction ID|Order Date|Customer ID|Product ID|Total Amount|Status
            writer.write(
                transaction.getTransactionID() + "|" + 
                transaction.getOrderDate().toString() + "|" + 
                transaction.getCustomerID() + "|" + 
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
                updatedTransaction.getCustomerID() + "|" + 
                updatedTransaction.getProductID() + "|" + 
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
            return;
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
    public static Queue<Transaction> loadOrders(ArrayList<Product> products, ArrayList<Customer> customers) {
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
                        Customer.getCustomer(customers, attributes[2]),
                        attributes[3], 
                        Product.getProduct(products, attributes[3]),
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
    final static File customerFile = new File("Customer.txt");

    public static ArrayList<Customer> loadCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");
                customers.add(new Customer(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5]));
            }
            System.out.println(">> Customers fetched successfully.");

        } catch (Exception e) {
            System.out.println(">> An error occurred while reding the customer file.");
            e.printStackTrace();
        }
        return customers;
    }
    
    public static int getLastCustomerID() {
        // check if the file exists or is empty
        if (!customerFile.exists() || customerFile.length() == 0) {
            System.out.println(">> There are no customers.");
            return 0;
        }
        String lastLine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lastLine = currentLine;
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the customer file.");
            e.printStackTrace();
        } 
        return Integer.parseInt(lastLine.split("\\|")[0]);
    }

    public static void saveCustomer(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerFile, true))) {
            writer.write(customer.getCustomerID() + "|" +
            customer.getLastName() + "|" +
            customer.getFirstName() + "|" +
            customer.getMiddleName() + "|" +
            customer.getContactNumber() + "|" +
            customer.getAddress()
        );
        writer.newLine();
        } catch (Exception e) {
            System.out.println(">> An error occurred while saving the customer to file.");
            e.printStackTrace();
        }
    }

    // CASHIER FILE HADNLER
    final static File cashierFile = new File("Cashier.txt");
    public static boolean cashierIDExists(String cashierID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cashierFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.split("\\|")[0].equals(cashierID)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the cashier file.");
            e.printStackTrace();
        }
        return false;
    }

    public static Cashier getCashier(String cashierID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cashierFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");

                if (attributes[0].equals(cashierID)) {
                    return new Cashier(cashierID, attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6]);
                }
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the cashier file.");
            e.printStackTrace();
        }
        return new Cashier();
    }
}