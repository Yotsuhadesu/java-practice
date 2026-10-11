import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileHandler {
    private static File file = new File("Transactions.tsv");

    // Transaction_ID	Date	Last_Name	First_Name	Contact_Number	Delivery_Address	Item    Quantity    Item_Price  Delivery_Fee    Total_Amount	Payment_Method	Status
    public static String toLine(Record record) {
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
            e.printStackTrace();
        }
        
        return maxId;
    }

	public static boolean saveTransactions(ArrayList<Transaction> transactions) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (Transaction transaction : transactions) {
				writer.write(toLine(transaction));
				writer.newLine();
			}
			return true;
		} catch (Exception e) {
			System.out.println(">> An error occurred while saving transactions to file.");
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<Transaction> loadTransactions() {
		ArrayList<Transaction> transactions = new ArrayList<>();
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				String[] lineParts = line.split("\t");
				transactions.add(new Transaction(
						Integer.parseInt(lineParts[0]), 
						LocalDate.parse(lineParts[1]), 
						lineParts[2], 
						lineParts[3], 
						lineParts[4], 
						lineParts[5], 
						lineParts[6], 
						Integer.parseInt(lineParts[7]), 
						new BigDecimal(lineParts[8]), 
						new BigDecimal(lineParts[9]), 
						new BigDecimal(lineParts[10]), 
						lineParts[11], 
						lineParts[12]));
			}
		} catch (Exception e) {
			System.out.println(">> An error occurred while loading transactions.");
			e.printStackTrace();
		}
		return transactions;
	}
}