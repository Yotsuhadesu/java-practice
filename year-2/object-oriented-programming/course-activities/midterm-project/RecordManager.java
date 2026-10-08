public interface RecordManager {
    boolean addRecord(Record record);
    boolean updateRecord(Record record);
    boolean deleteRecord(Record record);
    Record getRecord(int id);
    int findRecord(String searchkey);
}
