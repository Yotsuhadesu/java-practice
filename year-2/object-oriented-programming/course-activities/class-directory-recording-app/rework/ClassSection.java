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
        ArrayList<Student> sortedStudents = new ArrayList<>();
        int size = this.students.size();

        for (int i = 1; i < size; i++) {
            Student student = this.students.get(i);
            String keyLastName = student.
            int j = i - 1;
            
            while (j >= 0 && ) {

            }
        }
    }
}