import java.util.ArrayList;

public class ClassRecord implements ClassList{
    College college = new College();
    Program program = new Program();
    Course course = new Course();
    Faculty faculty = new Faculty(null, null, null, null, null);
    ArrayList <Student> students = new ArrayList<>();
    
    @Override 
    public void assignCollegeDetails() {
        System.out.println("--- COLLEGE & PROGRAM ASSIGNMENT ---");
        college.setCollegeCode(Input.acceptString("Enter College Code:"));
        college.setCollegeName(Input.acceptString("Enter College Name:"));
        System.out.println(">> College successfully assigned!");
    }
    @Override
    public void assignProgramDetails() {
        program.setProgramCode(Input.acceptString("Enter Program Code:"));
        program.setProgramName(Input.acceptString("Enter Program Name:"));
        System.out.println(">> Program successfully assigned!");
    }
    @Override 
    public void assignCourseDetails() {
        System.out.println("--- COURSE (SUBJECT) DETAILS ---");
        course.setSubjectName(Input.acceptString("Enter Subject Code:"));
        course.setSubjectCode(Input.acceptString("Enter Subject ID:"));
        course.setSubjectID(Input.acceptString("Enter Subject Name:"));
        course.setUnits(Input.acceptInt("Enter Units:"));
        System.out.println(">> Course details successfully set!");

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
