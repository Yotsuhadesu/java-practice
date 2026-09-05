import java.io.File;

public class FileProcess {
    
    public void saveToFile(ClassRecord classRecord) {
        File file = new File("ClassRecord_ " + classRecord.course.getCourseCode() + ".txt");
        if (!file.exists()) {
            System.out.println("Creating " + file.getName() + ".");
            System.out.println(file.getName() + " successfully created!");
        }
        
    }
    
    public void loadFromFile() {

    }
}
