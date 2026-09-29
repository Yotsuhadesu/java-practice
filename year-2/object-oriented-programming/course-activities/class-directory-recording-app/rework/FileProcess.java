import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileProcess {
    private static File file = new File("ClassDirectory.txt");

    public static void saveDirectory(ClassSection classSection) {
        if (file.exists()) {
            try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(file))) {
                // write class to file
                // format: Class|Grade Level|Section
                bWriter.write("Class|" + classSection.getGradeLevel() + "|" + classSection.getSection());
                bWriter.newLine();

                Adviser adviser = classSection.getAdviser();
                if (adviser != null) {
                    // write adviser to file
                    // format: Adviser|Last Name|First Name|Middle Name|Gender|Birth Date|Contact Num|Degree
                    bWriter.write(
                        "Adviser|" + 
                        adviser.getLastName() + "|" + 
                        adviser.getFirsttName() + "|" + 
                        adviser.getMiddleName() + "|" +
                        adviser.getGender() + "|" +
                        adviser.getBirthDate() + "|" +
                        adviser.getContactNumber() + "|" +
                        adviser.getDegree()
                    );
                    bWriter.newLine();
                }

                ArrayList<Student> students = classSection.getStudents();
                if (students != null || students.size() != 0) {
                    // write student to file
                    for (Student student : students) {
                        // format: Student|LRN|last Name|First Name|Middle Name|gender|Birth Date|Contact Num|Address
                        bWriter.write(
                            "Student|" + 
                            student.getLRN() + "|" + 
                            student.getLastName() + "|" +
                            student.getFirsttName() + "|" +
                            student.getMiddleName() + "|" +
                            student.getGender() + "|" +
                            student.getBirthDate() + "|" + 
                            student.getContactNumber() + "|" +
                            student.getAddress()
                        );
                        bWriter.newLine();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exist. Please create \"ClassDirectory.txt\"");
        }
    }

    public static void loadDirectory(ClassSection classSection) {
        if (file.exists() && file.length() != 0) {
            try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = bReader.readLine()) != null) {
                    String[] attributes = line.split("\\|");
    
                    switch (attributes[0]) {
                        case "Class":
                            // format: Class|Grade Level|Section
                            classSection.setGradelevel(attributes[1]);
                            classSection.setSection(attributes[2]);
                            break;
                        case "Adviser":
                            // format: Adviser|Last Name|First Name|Middle Name|
                            // Gender|Birth Date|Contact Number|Degree
                            String adLastName = attributes[1];
                            String adFirstName = attributes[2];
                            String adMiddleName = attributes[3];
                            String adGender = attributes[4];
                            String adBirthdate = attributes[5];
                            long adContactNumber = Long.parseLong(attributes[6]);
                            String adDegree = attributes[7];
                            classSection.setAdviser(new Adviser(adDegree, adLastName, adFirstName, adMiddleName, adGender, adBirthdate, adContactNumber));
                            break;
                        case "Student":
                            // Student|LRN|Last Name|First Name|Middle Name|Gender|Birth Date|Contact Number|Address
                            long stLRN = Long.parseLong(attributes[1]);
                            String stLastName = attributes[2];
                            String stFirstName = attributes[3];
                            String stMiddleName = attributes[4];
                            String stGender = attributes[5];
                            String stBirthdate = attributes[6];
                            long stContactNumber = Long.parseLong(attributes[7]);
                            String stAddress = attributes[8];
                            // public Student(long lrn, String address, String lastName, String firsttName, String middleName, String gender, String birthDate, long contactNumber)
                            classSection.addStudent(new Student(stLRN, stAddress, stLastName, stFirstName, stMiddleName, stGender, stBirthdate, stContactNumber));
                            break;
                        default:
                            System.out.println("Invalid category.");
                            break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exist or is empty.");
        }
    }

    public static void editStudent(ClassSection classSection) {
        if (classSection.getStudents() == null || classSection.getStudents().size() == 0) {
            System.out.println("No student enbrolled yet. Please add a student first.");
            return;
        }
        System.out.print("Enter LRN: ");
        long inputLRN = UserInput.acceptLong();
        UserInput.acceptString();
        boolean found = false;
        for (Student student : classSection.getStudents()) {
            if (student.getLRN() == inputLRN) {
                System.out.println("""
                        1. LRN
                        2. Last Name
                        3. First Name
                        4. Middle Name
                        5. Gender
                        6. BirthDate
                        7. Contact Number
                        8. Home Address
                        9. Exit
                        Choice:\t""");
                int choice = UserInput.acceptInt();
                UserInput.acceptString();
                switch (choice) {
                    case 1:
                        System.out.print("Enter LRN: ");
                        student.setLRN(UserInput.acceptLong());
                        UserInput.acceptString();
                        break;
                    case 2:
                        System.out.print("Enter Last Name: ");
                        student.setLastName(UserInput.acceptString());
                        break;
                    case 3:
                        System.out.print("Enter First Name: ");
                        student.setFirstName(UserInput.acceptString());
                        break;
                    case 4:
                        System.out.print("Enter Middle Name: ");
                        student.setMiddleName(UserInput.acceptString());
                        break;
                    case 5:
                        System.out.print("Enter Gender: ");
                        student.setGender(UserInput.acceptString());
                        break;
                    case 6:
                        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
                        student.setBirthDate(UserInput.acceptString());
                        break;
                    case 7:
                        System.out.print("Enter Contact Number: ");
                        student.setContactNumber(UserInput.acceptLong());
                        break;
                    case 8:
                        System.out.print("Enter Home Address: ");
                        student.setAddress(UserInput.acceptString());
                        break;
                    case 9:
                        System.out.println("Exiting the updating student system...");
                        return;
                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
                found = true;
                break; // stop once match is updated
            }
        }
        if (!found) {
            System.out.println("LRN not found.");
        }
    }
}
