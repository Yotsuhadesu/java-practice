public class Student extends Person{
    private String studentNumber;
    private String gender;
    private String course;

    public Student(String firstName, String middleName, String lastName,
        String studentNumber, String gender, String course
    ) {
        super(firstName, middleName, lastName);
        this.studentNumber = studentNumber;
        this.gender = gender;
        this.course = course;
    }

    @Override
    public String getCompleteName() {
        return String.format("%s, %s %s.", lastName, firstName, middleName.charAt(0));
    }
}
