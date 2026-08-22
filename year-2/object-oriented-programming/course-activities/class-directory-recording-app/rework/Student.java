public class Student extends Person{    // extends keyword to make it a child of the Person class
    // encapsulated fields
    private long lrn;
    private String address;

    // constructor
    public Student(long lrn, String address, String lastName, String firsttName, 
                   String middleName, String gender, String birthDate, long contactNumber) {
        super(lastName, firsttName, middleName, gender, birthDate, contactNumber);    // super keyword to inherit the constructor of the parent class
        this.lrn = lrn;
        this.address = address;
    }
}
