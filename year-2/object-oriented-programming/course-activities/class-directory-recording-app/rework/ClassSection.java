import java.rmi.StubNotFoundException;
import java.util.ArrayList;

public class ClassSection {
    private String gradeLevel;
    private String section;
    private Adviser adviser;    // Adviser object
    private ArrayList<Student> students;    // ArrayList of Student objects 

    public ClassSection(String gradeLevel, String section, Adviser adviser, ArrayList<Student> students) {
        this.gradeLevel = gradeLevel;
        this.section = section;
        this.adviser = adviser;
        this.students = students;
    }

    public void setGradelevel(String gradeLevel) { this.gradeLevel = gradeLevel; }

    public void setSection(String section) { this.section = section; }

    public Adviser getAdviser() { return adviser; }

    public ArrayList<Student> getStudents() { return students; }

    public static void viewClassDirectory(ClassSection classSection) {
        
    }

    public ArrayList<Student> sortedStudents() {
        ArrayList<Student> sortedStudents = new ArrayList<>(this.students);
        int size = sortedStudents.size();

        for (int i = 1; i < size; i++) {
            String keyLastName = sortedStudents.get(i).getLastName();
            int j = i - 1;
            
            while (j >= 0 &&  sortedStudents.get(j).getLastName().compareToIgnoreCase(keyLastName) > 0) {
                
                j--;
            }
        }
    }
}