public class Faculty extends Person{
    private String facultyID;
    private String degree;

    public Faculty(String firstName, String middleName, String lastName,
        String facultyID, String degree
    ) {
        super(firstName, middleName, lastName);
        this.facultyID = facultyID;
        this.degree = degree;
    }

    @Override
    public String getCompleteName() {
        return String.format("%s %s. %s, %s", firstName, middleName.charAt(0), lastName, degree);
    }
}
