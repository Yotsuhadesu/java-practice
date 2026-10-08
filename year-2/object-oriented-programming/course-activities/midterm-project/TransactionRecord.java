public class TransactionRecord implements RecordManager {
    @Override 
    public boolean addRecord(Record record) {
        return false;
    }
    @Override 
    public boolean updateRecord(Record record) {
        return false;
    }
    @Override 
    public boolean deleteRecord(Record record) {
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
