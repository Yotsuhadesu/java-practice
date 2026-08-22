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
                            Adviser adviser = classSection.getAdviser();
                            if (adviser == null) {
                                adviser = new Adviser(adDegree, adLastName, adFirstName, adMiddleName, adGender, adBirthdate, adContactNumber);
                            }
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
                            ArrayList<Student> students = classSection.getStudents();
                            if (students == null) {
                                students = new ArrayList<>();
                            }
                            // public Student(long lrn, String address, String lastName, String firsttName, String middleName, String gender, String birthDate, long contactNumber)
                            students.add(new Student(stLRN, stAddress, stLastName, stFirstName, stMiddleName, stGender, stBirthdate, stContactNumber));
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
}
