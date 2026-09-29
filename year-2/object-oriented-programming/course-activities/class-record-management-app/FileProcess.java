import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileProcess {
    public static void saveToFile(ClassRecord classRecord) {
        System.out.println("--- PERSISTENT FILE STORAGE ---");
        File file = new File("ClassRecord_" + classRecord.course.getCourseCode() + ".txt");
        if (!file.exists()) {
            System.out.println("Creating " + file.getName() + ".");
            System.out.println(file.getName() + " successfully created!");
        }

        System.out.printf("Saving current class record to \"%s\"...\n", file.getName());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // save college
            College college = classRecord.college;
            writer.write("COLLEGE|" + 
                college.getCollegeCode() + "|" +
                college.getCollegeName()
            );
            writer.newLine();
            
            // save program
            Program program = classRecord.program;
            writer.write("PROGRAM|" + 
            program.getProgramCode() + "|" +
            program.getProgramName()
            );
            writer.newLine();

            // save course
            Course course = classRecord.course;
            writer.write("COURSE|" + 
                course.getCourseCode() + "|" +
                course.getCourseID() + "|" +
                course.getCourseName() + "|" + 
                course.getUnits()
            );
            writer.newLine();
            
            // save faculty
            Faculty faculty = classRecord.faculty;
            writer.write("FACULTY|" + 
                faculty.getFacultyID() + "|" +
                faculty.getFirstName() + "|" +
                faculty.getMiddleName() + "|" +
                faculty.getLastName() + "|" +
                faculty.getDegree()
            );
            writer.newLine();

            // save students
            ArrayList<Student> students = classRecord.students;
            for(Student student : students) {
                writer.write("STUDENT|" + 
                    student.getStudentNumber() + "|" +
                    student.getFirstName() + "|" +
                    student.getMiddleName() + "|" +
                    student.getLastName() + "|" +
                    student.getGender() + "|" + 
                    student.getCourse()
                );
                writer.newLine();
            }
            System.out.println(">>> Class record data saved successfully!");
        } catch (Exception e) {
            System.out.println("Cannot save the class record to " + file.getName() + ".");
        }
    }
    
    public static void loadFromFile(ClassRecord classRecord) {
        File file = new File("ClassRecord_" + classRecord.course.getCourseCode() + ".txt");
        if (!file.exists()) {
            System.out.println(file.getName() + " doesn't exist. Please save the class record to file first.");
            return;
        }

        System.out.printf("Fetching class record data from \"%s\"...\n", file.getName());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");

                switch (attributes[0]) {
                    case "COLLEGE":
                        classRecord.college.setCollegeCode(attributes[1]);
                        classRecord.college.setCollegeName(attributes[2]);
                        break;
                    case "PROGRAM":
                        classRecord.program.setProgramCode(attributes[1]);
                        classRecord.program.setProgramName(attributes[2]);
                        break;
                    case "COURSE":
                        classRecord.course.setCourseCode(attributes[1]);
                        classRecord.course.setCourseID(attributes[2]);
                        classRecord.course.setCourseName(attributes[3]);
                        classRecord.course.setUnits(Integer.parseInt(attributes[4]));
                        break;
                    case "FACULTY":
                        classRecord.faculty.setFacultyID(attributes[1]);
                        classRecord.faculty.setFirstName(attributes[2]);
                        classRecord.faculty.setMiddleName(attributes[3]);
                        classRecord.faculty.setLastName(attributes[4]);
                        classRecord.faculty.setDegree(attributes[5]);
                        break;
                    case "STUDENT":
                        String studentNumber = attributes[1];
                        String firstName = attributes[2];
                        String middleName = attributes[3];
                        String lastName = attributes[4];
                        String gender = attributes[5];
                        String course = attributes[6];
                        Student student = new Student(firstName, middleName, lastName, studentNumber, gender, course);
                        classRecord.students.add(student); 
                        break;
                    default:
                        System.out.println("Invalid classification encountered: " + attributes[0]);
                        break;
                }
            }
            System.out.println(">>> Class record data fetched successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while reading " + file.getName() + ".");
        }
    }
}
