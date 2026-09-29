public interface ClassList {
    int MAX_STUDENTS = 40;

    default void getInstitutionName() {
        System.out.println("University of Nueva Caceres");
    }

    void assignCollegeDetails();
    void assignProgramDetails();
    void assignCourseDetails();
    void assignInstructorDetails();
    void addStudent();
    void removeStudent();
    void displayStudents();
    void displayClassRecord();
}
