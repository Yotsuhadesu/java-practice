public class Main {
    public static void main(String[] args) {
        ClassRecord classRecord = new ClassRecord();
        int choice;
        do {
            choice = Input.acceptInt("Select option:");
            switch (choice) {
                case 1:
                    classRecord.assignCollegeDetails();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 0:
                    System.out.println("Exiting system. Thank you for using UNC Class Record System!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while(choice != 0);
    }
}