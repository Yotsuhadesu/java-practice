import java.util.ArrayList;

public class ClassRecord implements ClassList{
    College college;
    Program program;
    Course course;
    Faculty faculty;
    ArrayList <Student> students;
    
    @Override 
    public void assignCollegeDetails() {
        System.out.println("--- COLLEGE & PROGRAM ASSIGNMENT ---");
        college.setCollegeCode(Input.acceptString("Enter College Code:"));
        college.setCollegeName(Input.acceptString("Enter College Name:"));
        program.setProgramCode(Input.acceptString("Enter Program Code:"));
        program.setProgramName(Input.acceptString("Enter Program Name:"));
    }
    @Override
    public void assignProgramDetails() {

    }
    @Override
    public void assignInstructorDetails() {

    }
    @Override
    public void addStudent() {

    }
    @Override
    public void removeStudent() {

    }
    @Override
    public void displayStudents() {

    }
    @Override
    public void displayClassRecord() {

    }
}
