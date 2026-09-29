import java.time.LocalDate;
import java.time.Period;

public class Person {
    // protected keyword so that these can only be used by classes inside the package and the child classes
    protected String lastName;
    protected String firsttName;
    protected String middleName;
    protected String gender;
    protected String birthDate;
    protected long contactNumber;
    private int age;

    /**
     * Constructor to be passed to child classes
     * 
     * @param lastName
     * @param firsttName
     * @param middleName
     * @param gender
     * @param birthDate
     * @param contactNumber
     */
    public Person(String lastName, String firsttName, String middleName, 
                  String gender, String birthDate, long contactNumber) {
        this.lastName = lastName;
        this.firsttName = firsttName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
    }

    public void computeAge() {
        LocalDate birthDate = LocalDate.parse(this.birthDate);
        LocalDate currDate = LocalDate.now();
        this.age = Period.between(birthDate, currDate).getYears();
    }

    public int getAge() {
        return this.age;
    }
}
