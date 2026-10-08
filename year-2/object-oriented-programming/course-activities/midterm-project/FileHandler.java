import java.util.ArrayList;

public class FileHandler {
    // Transaction_ID	Date	Last_Name	First_Name	Contact_Number	Delivery_Address	Item    Quantity    Item_Price  Delivery_Fee    Total_Amount	Payment_Method	Status
    private static String toLine(Record record) {
        ArrayList<Object> recordData = record.getRecordData();
        ArrayList<String> stringRecordData = new ArrayList<>();

        for (Object data : recordData) {
            stringRecordData.add(String.valueOf(data));
        }

        return String.join("\t", stringRecordData);
    } 
}