public interface RecordManager {
    void addRecord();
    void updateRecord();
    void deleteRecord();
    void viewRecord();
    void viewList();
    int findRecord();
    void findRecord(String searchKey);
}