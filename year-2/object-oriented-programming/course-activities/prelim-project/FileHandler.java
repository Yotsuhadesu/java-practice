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
        System.out.println("PRODUCT | PRICE PER PIECE | STOCK");
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productAttributes = line.split("\\|");
                System.out.println(productAttributes[0] + " | " + productAttributes[1] + " | " + productAttributes[2]);
            }
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading the file.");
            e.printStackTrace();
        } 
    }
}
