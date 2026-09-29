import java.rmi.StubNotFoundException;
import java.util.ArrayList;

public class ClassSection {
    private String gradeLevel;
    private String section;
    private Adviser adviser;    // Adviser object
    private ArrayList<Student> students;    // ArrayList of Student objects 
    private ArrayList<Student> sortedStudents;

    // constructors
    /*
    public ClassSection(String gradeLevel, String section, Adviser adviser, ArrayList<Student> students) {
        this.gradeLevel = gradeLevel;
        this.section = section;
        this.adviser = adviser;
        this.students = students;
    }
    */
    public ClassSection() {
        this.gradeLevel = null;
        this.section = null;
        this.adviser = new Adviser();
        this.students = new ArrayList<>();
    }

    public void setGradelevel(String gradeLevel) { this.gradeLevel = gradeLevel; }

    public void setSection(String section) { this.section = section; }

    public void setAdviser(Adviser adviser) {this.adviser = adviser; }

    public void addStudent(Student student) { students.add(student); }

    public String getGradeLevel() { return this.gradeLevel; }
    
    public String getSection() { return this.section; }
    
    public Adviser getAdviser() { return adviser; }

    public ArrayList<Student> getStudents() { return students; }

    public ArrayList<Student> getSortedStudents() { return this.sortedStudents; }

    public void viewClassDirectory(ClassSection classSection) {
        // show class info
        System.out.println("=".repeat(75));
        System.out.println("CLASS SECTION DIRECTORY");
        System.out.printf("Grade Level: %s\tSection: %s\n", classSection.getGradeLevel(), classSection.getSection());
        System.out.println("-".repeat(75));

        // show adviser info
        System.out.println("ADVISER INFORMATION");
        Adviser adviser = classSection.getAdviser();
        String adLastName = adviser.getLastName();
        String adFirstName = adviser.getFirsttName();
        String adMiddleName = adviser.getMiddleName();
        String adGender = adviser.getMiddleName();
        String adBirthdate = adviser.getBirthDate();
        adviser.computeAge();   // compute the age first
        int adAge = adviser.getAge();
        long adContactNumber = adviser.getContactNumber();
        String adDegree = adviser.getDegree();
        System.out.printf("Name: Prof. %s %s %s\n", adFirstName, adMiddleName, adLastName);
        System.out.printf("Gender: %s | Birthdate: %s (Age: %d)\n", adGender, adBirthdate, adAge);
        System.out.printf("Contact: %d | Degree: %s\n", adContactNumber, adDegree);
        System.out.println("-".repeat(75));


        // show student list
        classSection.sortStudents();    // sort the students in a dedicated ArrayList first
        ArrayList<Student> sortedStudents =  classSection.getSortedStudents();  // make an ArrayList that points to the sorted ArrayList
        System.out.println("ENROLLED STUDENTS (Sorted Alphabetically - Total: " + sortedStudents.size() + ")");
        int i = 1;  // counter variable
        for (Student student : sortedStudents) {
            long stLRN = student.getLRN();
            String stLastName = student.getLastName();
            String stFirstName = student.getFirsttName();
            String stMiddleName = student.getMiddleName();
            String stGender = student.getMiddleName();
            String stBirthdate = student.getBirthDate();
            student.computeAge();
            int stAge = student.getAge();
            long stContactNumber = student.getContactNumber();
            String stAddress = student.getAddress();

            System.out.printf("[%02d]\tLRN: %d\n", i, stLRN);
            System.out.printf("\tName: %s, %s %s\n", stFirstName, stLastName, stMiddleName);
            System.out.printf("\tGender: %s |  Birthdate: %s (Age: %d) | Contact: %d\n", stGender, stBirthdate, stAge, stContactNumber);
            System.out.printf("\tAddress: %s\n", stAddress);
            i++;
        }
        System.out.println("=".repeat(75));
    }

    public void sortStudents() {
        ArrayList<Student> sortedStudents = new ArrayList<>(this.students);

        int size = sortedStudents.size();
        for (int i = 1; i < size; i++) {
            Student key = sortedStudents.get(i);
            String keyLastName = key.getLastName();
            int j = i - 1;  // sorted Student object(s) boundary
            
            while (j >= 0 &&  sortedStudents.get(j).getLastName().compareToIgnoreCase(keyLastName) > 0) {
                sortedStudents.set(j + 1, sortedStudents.get(j));
                j--;
            }
            // place the unsorted element to its correct position
            sortedStudents.set(j + 1, key);
        }
        this.sortedStudents =  sortedStudents;
    }
}