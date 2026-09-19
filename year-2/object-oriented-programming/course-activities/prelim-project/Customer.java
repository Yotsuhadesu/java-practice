public class Customer extends Person{
    public Customer(String personID, String lastName, String firstName, String middleName, String contactNumber, String address) {
        super(personID, lastName, firstName, middleName, contactNumber, address);
    }

    public static Customer askCustomerInfo() {
        String lastName = Input.acceptString("Last Name:");
        String firstName = Input.acceptString("First Name:");
        String middleName = Input.acceptString("Middle Name:");
        String contactNumber = Input.acceptString("Contact Number:");
        String address = Input.acceptString("Address:");
        return new Customer("0", lastName, firstName, middleName, contactNumber, address);
    }
}
