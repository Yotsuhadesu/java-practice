import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileHandler {
    private static File file = new File("Transactions.tsv");

    // Transaction_ID	Date	Last_Name	First_Name	Contact_Number	Delivery_Address	Item    Quantity    Item_Price  Delivery_Fee    Total_Amount	Payment_Method	Status
    private static String toLine(Record record) {
        ArrayList<Object> recordData = record.getRecordData();
        ArrayList<String> stringRecordData = new ArrayList<>();

        for (Object data : recordData) {
            stringRecordData.add(String.valueOf(data));
        }

        return String.join("\t", stringRecordData);
    } 

    public static int getLastTranId() {
        int maxId = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int currentId = Integer.parseInt(line.split("\t")[0]);
                if (currentId > maxId) {
                    maxId = currentId;
                } else if (currentId == maxId) {
                    System.out.println(">> Identical transaction ids detected: " + currentId);
                }
            }

            System.out.println(">> Last transaction id found.");
        } catch (Exception e) {
            System.out.println(">> An error occurred while finding the last transaction id.");
        }
        
        return maxId;
    }
}