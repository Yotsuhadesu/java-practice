import java.util.ArrayList;

public class ClassRecord implements ClassList{
    College college = new College();
    Program program = new Program();
    Course course = new Course();
    Faculty faculty = new Faculty(null, null, null, null, null);
    ArrayList <Student> students = new ArrayList<>();
    ArrayList <Student> sortedStudents = new ArrayList<>(); 
    
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
        course.setSubjectCode(Input.acceptString("Enter Subject Code:"));
        course.setSubjectID(Input.acceptString("Enter Subject ID:"));
        course.setSubjectName(Input.acceptString("Enter Subject Name:"));
        course.setUnits(Input.acceptInt("Enter Units:"));
        System.out.println(">> Course details successfully set!");

    }
    @Override
    public void assignInstructorDetails() {
        System.out.println("--- FACULTY INSTRUCTOR ASSIGNMENT ---");
        faculty.setFacultyID(Input.acceptString("Enter Faculty ID:"));
        faculty.setFirstName(Input.acceptString("Enter First Name:"));
        faculty.setMiddleName(Input.acceptString("Enter Middle Name:"));
        faculty.setLastName(Input.acceptString("Enter Last Name:"));
        faculty.setDegree(Input.acceptString("Enter Highest Degree:"));
        System.out.println(">> Instructor successfully assigned!");
    }
    @Override
    public void addStudent() {
        if (students.size() == MAX_STUDENTS) {
            System.out.println("The current class is at full capacity. It cannot accept more students.");
        }
        System.out.printf("--- ADD ENROLLED STUDENT (Current: %d/%d) ---\n", students.size(), MAX_STUDENTS);
        String studentNumber = Input.acceptString("Enter Student No:");
        String firstName = Input.acceptString("Enter First Name:");
        String middleName = Input.acceptString("Enter Middle Name:");
        String lastName = Input.acceptString("Enter Last Name:");
        String gender = Input.acceptString("Enter Gender:");
        String course = Input.acceptString("Enter Course Enrolled:");
        Student student = new Student(firstName, middleName, lastName, studentNumber, gender, course);
        students.add(student);
        System.out.printf(">> Student %s added successfully!\n", student.getCompleteName());
    }
    @Override
    public void removeStudent() {
        String studentNumber = Input.acceptString("Enter Student Number:");
        students.removeIf(student -> student.getStudentNumber().equals(studentNumber));
        System.out.println(">>> Student successfully removed!");
    }
    @Override
    public void displayStudents() {
        switch (Input.acceptInt("""
                === ENROLLED STUDENT LIST ===
                [1] Sort Alphabetically
                [2] Display in Order Added
                Select option:""")) {
            case 1:
                System.out.println("Bayoretto Ebegaden des");
                break;
            case 2:
                displayStudents(students);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    @Override
    public void displayClassRecord() {

    }

    public void sortStudents() {
        this.sortedStudents = this.students;
        for (int i = 1; i < sortedStudents.size(); i++) {
            Student key = sortedStudents.get(i);
            int j = i - 1;
            while (j >= 0 && sortedStudents.get(j).getCompleteName().compareToIgnoreCase(key.getCompleteName()) > 0) {
                sortedStudents.set(j + 1, sortedStudents.get(j));
            }
            sortedStudents.set(j + 1, key);
        }
    }

    public void displayStudents(ArrayList<Student> students) {
        int i = 1;
        System.out.println("-".repeat(100));
        System.out.printf("%-2s %-15s %-50s %-10s %-20s\n", "#", "STUDENT NO.", "COMPLETE NAME (Lastname, Firstname M.I.)", "GENDER", "COURSE ENROLLED");
        System.out.println("-".repeat(100));
        for (Student student : students) {
            System.out.printf("%-2d %-15s %-50s %-10s %-20s\n", i, student.getStudentNumber(), student.getCompleteName(), student.getGender(), student.getCourse());
            i++;
        }
        System.out.println("-".repeat(100));
        System.out.printf("Total Enrolled: %d / %d Students\n", students.size(), MAX_STUDENTS);
    }
}
