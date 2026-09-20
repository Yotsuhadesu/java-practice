import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {
    final static File productsFile = new File("Products.txt");
    public static void showProducts() {
        System.out.println("--- PRODUCTS ---");
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
                    System.out.printf(">> %s: P%.2f", productName, price);
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
}
