public class Cashier extends Person {
    private String password;
    public Cashier(String id, String lastName, String firstName, String middleName, String contactNumber, String address, String password) {
        super(id, lastName, firstName, middleName, contactNumber, address);
        this.password = password;
    }
    public Cashier() {

    }

    public String getPassword() {
        return this.password;
    }

    public static Cashier logIn() {
        String id = Input.acceptString("Cashier ID:");
        while (!FileHandler.cashierIDExists(id)) {
            System.out.println(">> Cashier ID does not exist.");
            if (Input.acceptBoolean(">> Exit? (true/false)")) {
                return new Cashier();
            }

            id = Input.acceptString("Cashier ID:");
        }
        Cashier cashier = FileHandler.getCashier(id);
        String password = Input.acceptString("Password:");
        while (true) {
            if (!password.equals(cashier.getPassword())) {
                System.out.println(">> Wrong password.");
                if (Input.acceptBoolean(">> Exit? (true/false)")) {
                    return new Cashier();
                }
                password = Input.acceptString("Password:");
            } else {
                return cashier;
            }
        }
    }
}
