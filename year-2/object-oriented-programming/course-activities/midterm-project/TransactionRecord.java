import java.util.ArrayList;

public class TransactionRecord implements RecordManager {
    ArrayList<Transaction> transactions = new ArrayList<>();

    @Override 
    public boolean addRecord(Record transaction) {
        return false;
    }
    @Override 
    public boolean updateRecord(Record transaction) {
        return false;
    }
    @Override 
    public boolean deleteRecord(Record transaction) {
        return false;
    }
    @Override 
    public Record getRecord(int id) {
        return new Transaction();
    }
    @Override 
    public int findRecord(String searchKey) {
        return 0;
    }
}
