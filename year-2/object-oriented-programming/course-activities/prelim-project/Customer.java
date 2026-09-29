import java.util.ArrayList;

public class Customer extends Person{
    public Customer(String customerID, String lastName, String firstName, String middleName, String contactNumber, String address) {
        super(customerID, lastName, firstName, middleName, contactNumber, address);
    }

    public static Customer askCustomerInfo(ArrayList<Customer> customers) {
        boolean isNew = Input.acceptBoolean("New Customer (true/false):");
        if (isNew) {
            System.out.println("CUSTOMER INFORMATION FORM");
            String customerID = String.format("%05d", FileHandler.getLastCustomerID() + 1);
            String lastName = Input.acceptString("Last Name:");
            String firstName = Input.acceptString("First Name:");
            String middleName = Input.acceptString("Middle Name:");
            String contactNumber = Input.acceptString("Contact Number:");
            String address = Input.acceptString("Address:");
            return new Customer(customerID, lastName, firstName, middleName, contactNumber, address);
        } else {
            do {
                String contactNumber = Input.acceptString("Contact Number:");
                for (Customer customer : customers) {
                    if (contactNumber.equals(customer.getContactNumber())) {
                        return customer;
                    }
                }
                System.out.println(">> Contact number doesn't exist.");
            } while (true);
           
        }
    }

    public void showCustomerInfo() {
        System.out.println("--- CUSTOMER INFORMATION ---");
        System.out.println("Name: " + getLastName() + ", " + getFirstName() + " " + getMiddleName());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Address: " + getAddress());
    }
}
