import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ClassSection classSection = new ClassSection();
        System.out.println("=== SCHOOL CLASS DIRECTORY SYSTEM ===");
        System.out.println("[1] View Class Directory");
        System.out.println("[2] Assign/Update Adviser");
        System.out.println("[3] Add Student");
        System.out.println("[4] Update Student by LRN");
        System.out.println("[5] Save Directory to File");
        System.out.println("[6] Load Directory from File");
        System.out.println("[7] Exit");

        int choice;
        do {
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    Adviser adviser = assignAdviser(scanner);
                    break;
                case 3:
                    addStudent(students, scanner);
                    break;
                case 4:
                    
                    break;
                case 5:
                    saveDirectory(classSection);
                    break;
                case 6:
                    
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while(choice != 7);
    }

    public static void viewClassDirectory() {

    }
    public static Adviser assignAdviser(Scanner scanner) {
        System.out.println("--- ASSIGN/UPDATE ADVISER ---");
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        long contactNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Highest Degree Earned: ");
        String highestDegree = scanner.nextLine();
        return new Adviser(lastName, firstName, middleName, gender, birthDate, contactNumber, highestDegree);
    }
    public static void addStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("--- ADD NEW STUDENT ---");
        System.out.print("Enter LRN: ");
        long lRN = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        long contactNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Home Address: ");
        String homeAddress = scanner.nextLine();
        students.add(new Student(lRN, lastName, firstName, middleName, gender, birthDate, contactNumber, homeAddress));
    }
    public static void saveDirectory(ClassSection classSection) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ClassDirectory.txt"))) {
            writer.write("Section," + classSection.getGradeLevel() + "," + classSection.getSection());
            writer.newLine();
            
            Adviser adviser = classSection.getAdviser();
            String advFullName = adviser.getFirstName() + " " + adviser.getMiddleName() + " " + adviser.getLastName();
            writer.write("Adviser," + advFullName + "," + adviser.getGender() + "," + adviser.getBirthDate() + "," + adviser.getContactNumber() + "," + adviser.getHighestDegree());
            writer.newLine();
            
            for (Student student : classSection.getStudents()) {
                String stFullName = student.getLastName() + "," + student.getFirstName() + "," + student.getMiddleName();
                writer.write("Student," + student.getLRN() + "," + stFullName + "," + student.getGender() + "," + student.getBirthDate() + "," + student.getContactNumber() + "," + student.getHomeAddress());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("An error occurred while saving the file.");
        }
    }
    public static void loadDirectory(File file, ClassSection classSection) {
        try(BufferedReader reader = new BufferedReader(file)) {

        }
    }
}
