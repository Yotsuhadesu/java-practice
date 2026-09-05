import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileProcess {
    
    public static void saveToFile(ClassRecord classRecord) {
        File file = new File("ClassRecord_ " + classRecord.course.getCourseCode() + ".txt");
        if (!file.exists()) {
            System.out.println("Creating " + file.getName() + ".");
            System.out.println(file.getName() + " successfully created!");
        }

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
        } catch (Exception e) {
            System.out.println("Cannot save the class record to " + file.getName() + ".");
        }
    }
    
    public void loadFromFile() {

    }
}
