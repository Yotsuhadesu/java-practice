public class Person {
    protected String personID;
    protected String lastName;
    protected String firstName;
    protected String middleName;
    protected String contactNumber;
    protected String address;

    public Person(String personID, String lastName, String firstName, String middleName, String contactNumber, String address) {
        this.personID = personID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.contactNumber = contactNumber;
        this.address = address;
    }
}
