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
    public Person() {
        
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    public String getContactNumber() {
        return this.contactNumber;
    }
    public String getAddress() {
        return this.address;
    }
}
